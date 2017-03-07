package usbListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.*;

import org.json.*;

import sensors.LuminositySensor;
import sensors.Sensor;
import sensors.TemperatureSensor;

import com.she.manager.DriverMqtt;


public class USBListener {

	void connect( String portName ) throws Exception {
		CommPortIdentifier portIdentifier = CommPortIdentifier
				.getPortIdentifier( portName );
		if( portIdentifier.isCurrentlyOwned() ) {
			System.out.println( "Error: Port is currently in use" );
		} else {
			int timeout = 2000;
			CommPort commPort = portIdentifier.open( this.getClass().getName(), timeout );

			if( commPort instanceof SerialPort ) {
				SerialPort serialPort = ( SerialPort )commPort;
				serialPort.setSerialPortParams( 9600,
						SerialPort.DATABITS_8,
						SerialPort.STOPBITS_1,
						SerialPort.PARITY_NONE );

				InputStream in = serialPort.getInputStream();
				OutputStream out = serialPort.getOutputStream();

				( new Thread( new SerialReader( in ) ) ).start();
				( new Thread( new SerialWriter( out ) ) ).start();

			} else {
				System.out.println( "Error: Only serial ports are handled by this example." );
			}
		}
	}

	public static class SerialReader implements Runnable {

		InputStream in;

		public SerialReader( InputStream in ) {
			this.in = in;
		}

		public void run() {

			byte[] buffer = new byte[ 1024 ];
			int len = -1;
			
			DriverMqtt driver = new DriverMqtt.DriverMqttBuilder().build("sensor");
			String message;
			Sensor sensor = new LuminositySensor(driver.getUsername(), "DHT");
			
			try {

				int i = 0;
				
				while( true ) {

					for ( i = 0; ( len = this.in.read() ) != '\n'; i++) {
						buffer[i] = (byte)len;
					}
					buffer[i] = '\0';
					message = new String(buffer);
					System.out.println(message);
					
//					Here the incoming value is transformed and published 
//					JSONObject json = new JSONObject(message);
//					int value =  json.getInt("value");
//					sensor.setValue(String.valueOf(value));
//					driver.publish(sensor.getValue());
					driver.publish(message);
				}
			} catch( IOException e ) {
				e.printStackTrace();
			} 
//			catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

	public static class SerialWriter implements Runnable {

		OutputStream out;

		public SerialWriter( OutputStream out ) {
			this.out = out;
		}

		public void run() {
			try {
				int c = 0;
				while( ( c = System.in.read() ) > -1 ) {
					this.out.write( c );
				}
			} catch( IOException e ) {
				e.printStackTrace();
			}
		}
	}

	public static void main( String[] args ) {
		try {
			( new USBListener() ).connect( "/dev/ttyACM0" );
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
}

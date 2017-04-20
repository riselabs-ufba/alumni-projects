package usbListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.*;
import com.she.manager.DriverMqtt;

/***
 * 
 * @author Ramon; Edilton;
 * @category Drive USB.
 */
public class USBListener {
	
	private static String hostMQTT = null;
	private String buildName = null; 
	private static final String LOCALHOST = "localhost";
	
	/***
	 * 
	 */
	public USBListener(){
		this(LOCALHOST);
	}	
	
	/***
	 * 
	 * @param hostMQTT	
	 */
	public USBListener(String hostMQTT){
		USBListener.hostMQTT = hostMQTT;		
	}	
	
	/***
	 * Listener the USB port.
	 * @param serialPort USB port to be listened to by the method.
	 * @throws Exception
	 */
	public void listener(SerialPort serialPort) {
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			
			// Pega o InputStream da porta serial.
			in = serialPort.getInputStream();
			// Pega o OutputStream da porta serial.
			out = serialPort.getOutputStream();	
			// Pega as propriedades do Sensor/atuador.
			this.getWhoAreYou(in);		
			
			if(this.buildName != null){
				if(!this.buildName.isEmpty()){
					// Executa a thread de leitura de dados.
					(new Thread(new SerialReader(in,this.buildName))).start();
					// Executa a thread de escrita de dados.
					(new Thread(new SerialWriter(out))).start();
				} else{
					// Pega as propriedades do Sensor/atuador.
					this.getWhoAreYou(in);	
				}
			}else{
				// Pega as propriedades do Sensor/atuador.
				this.getWhoAreYou(in);	
			}
		} catch (IOException e) {
			try{
					
				if (in != null){
					in.close();	
					in = null;
				}
				
				if(out != null){
					out.close();
					out = null;
				}
				
				if(serialPort != null){
					serialPort.close();
					serialPort = null;
				}
			} catch (IOException e1){
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}

	/***
	 * 
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	private void getWhoAreYou(InputStream in) throws IOException{
		
		String message = null;
		byte[] buffer = new byte[1024];
		int i = 0;
		int len = -1;
		
		for (i = 0; (len = in.read()) != '\n'; i++) {
			buffer[i] = (byte)len;
		}
		
		buffer[i] = '\0';
		message = new String(buffer);

		if (message.length() > 0){
			if (TrataMensagem.tryReadingV(message)){	
				message = TrataMensagem.getMensagem();
				System.out.println(message);				
				JsonDecode jsonDecode = new JsonDecode();
				jsonDecode.decodeMessagePropertyDevice(message);
				this.buildName = jsonDecode.getName();
			}else{
				this.getWhoAreYou(in);
			}
		}
	}
	
	/***
	 * This class is responsible for reading data from the USB port.
	 * @author Ramon; Edilton;
	 *
	 */
	public class SerialReader implements Runnable {

		private InputStream in = null;
		private String buildName = null;

		/***
		 * Constructor
		 * @param in
		 */
		public SerialReader(InputStream in) {
			this(in,"sensor/actuator");
		}
		
		/***
		 * 
		 * @param in
		 * @param buildName
		 */
		public SerialReader(InputStream in, String buildName) {
			this.in = in;
			this.buildName = buildName;
		}				
		
		/***
		 * Performs the process of reading data from the USB port.
		 */
		public void run() {

			byte[] buffer = new byte[1024];
			int len = -1;			
			DriverMqtt driver = new DriverMqtt.DriverMqttBuilder().host(USBListener.hostMQTT).build(this.buildName);
			String message = null;
			
			try {

				int i = 0;
				
				while(true) {
					
					for (i = 0; (len = this.in.read()) != '\n'; i++) {
						buffer[i] = (byte)len;
					}
					
					buffer[i] = '\0';		
									
					message = new String(buffer);	
					
					if (message.length() > 0){
						if (TrataMensagem.tryReadingV(message)){	
							// Pega a String no formato JSON.
							message = TrataMensagem.getMensagem();
											
							// Only for test.
							System.out.println(message);
							// Publish on MQTT server.
							driver.publish(message);
						}
					}									
				}
			} catch(IOException e) {
				try {
					
					if (in != null){
						in.close();
						in = null;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			} 
		}
	}

	/***
	 * 
	 * @author Ramon; Edilton;
	 *
	 */
	public class SerialWriter implements Runnable {

		private OutputStream out;

		public SerialWriter(OutputStream out) {
			this.out = out;
		}

		/***
		 * Read execute.
		 */
		public void run() {
			try {
				int c = 0;
				while((c = System.in.read()) > -1) {
					this.out.write(c);
				}
			} catch(IOException e) {
				e.printStackTrace();
				try {
					if(out != null){
						out.close();
						out = null;
					}					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();					
				}				
			}
		}
	}		
}
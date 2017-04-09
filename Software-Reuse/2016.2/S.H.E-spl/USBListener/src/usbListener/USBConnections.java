package usbListener;

import java.io.IOException;
import java.util.ArrayList;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

/***
 * 
 * @author Edilton
 *
 */
public class USBConnections {
	
	private ArrayList<String> usbPortList = null;
	private ArrayList<String> usbPortConnectedList = null;
	private SerialPortIdentifiers serialPortIdentifiers = null;
	
	/***
	 * 
	 */
	public USBConnections() {
		this.usbPortList = new ArrayList<String>();
		this.usbPortConnectedList = new ArrayList<String>();
		this.serialPortIdentifiers = new SerialPortIdentifiers(this.usbPortList);
	}
	
	/***
	 * 
	 * @return
	 */
	public ArrayList<String> getUSBPortConnectedList(){
				
		return this.usbPortConnectedList;
	}
	
	public static void main(String[] args) {
		USBConnections usbConnections = new USBConnections();
		
		try {
			usbConnections.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(usbConnections != null){
				usbConnections = null;
			}
		}
	}
	
	/***
	 * Conect to USBs ports.
	 * @throws Exception
	 */
	public void connect(){
		int timeout = 2000;		
		CommPortIdentifier commPortIdentifier = null;
		try{
		while(true){
			try {				
				this.serialPortIdentifiers.loadListUSBPort();
			} catch (Exception e) {
				return;
			}
			
			if (this.usbPortList.size() > 0){
				
				for(int i = 0; i < this.usbPortList.size(); i++) {
					
					// Obtains a CommPortIdentifier object by using a port name, defined in this.usbPortList.get(i).
					commPortIdentifier = CommPortIdentifier.getPortIdentifier(this.usbPortList.get(i));
						
					if(!commPortIdentifier.isCurrentlyOwned()) {
						USBListener usbListener = new USBListener();
						CommPort commPort = commPortIdentifier.open(this.getClass().getName(), timeout);
			
						// Verifica se a instância de commPort é do tipo SerialPort.
						if(commPort instanceof SerialPort) {
							SerialPort serialPort = (SerialPort)commPort;
							serialPort.setSerialPortParams(9600,
									SerialPort.DATABITS_8,
									SerialPort.STOPBITS_1,
									SerialPort.PARITY_NONE);
						
							// Passa a conexão para o USBListener.
							usbListener.listener(serialPort);	
							// Monta a lista de portas USB conectadas.
							this.usbPortConnectedList.add(this.usbPortList.get(i));
						} 
					}
				}
			}else{
				System.out.println("Nenhuma porta detectada!");
			}				
		}
	} catch (Exception e) {
		if (commPortIdentifier != null){			
			commPortIdentifier = null;
			e.printStackTrace();
		}		
	}
	}
}
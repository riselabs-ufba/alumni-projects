package usbListener;

import java.util.ArrayList;
import java.util.Enumeration;
import gnu.io.*;

/**
 * This class is intended to check if you have new connections on the USB ports.
 * @author Edilton
 * @since 12/03/2017.
 */
public class SerialPortIdentifiers {

	// Enuneration utilizado para a lista de portas disponíveis, pelo método estático getPortIdentifiers em CommPortIdentifier.
	private Enumeration enumerationList = null;
				
	// A list of USB port names.
	private static ArrayList<String> listUSBPort = new ArrayList<String>();				
	
	/***
	 * Constructor Method
	 * @param listPortUSB receives as a parameter a list of USB ports.
	 */
	public SerialPortIdentifiers(ArrayList<String> listPortUSB){
		SerialPortIdentifiers.listUSBPort = listPortUSB;
	}	
	
	/***
	 * Gets the name of the available USB ports.
	 * @return Returns a ArrayList<String> list of USB port names.
	 */
	private ArrayList<String> getPortIdentifiers()
	{
		ArrayList<String> listUSBPort = new ArrayList<String>();
		// captura a lista de portas disponíveis, pelo método estático getPortIdentifiers em CommPortIdentifier.
		this.enumerationList = CommPortIdentifier.getPortIdentifiers();		
				
		// Percorre a enumeração enquanto tiver o próximo elemento.
		while (this.enumerationList.hasMoreElements()) {				
			// Pega a porta do enmerationList.
			CommPortIdentifier commPortIdentifier = (CommPortIdentifier)this.enumerationList.nextElement();
		        
		    // Verifica se a porta é USB - Porta Serial.
		    if (commPortIdentifier.getPortType() == CommPortIdentifier.PORT_SERIAL) {
		    	// Adiciona o nome porta na Lista.
		    	listUSBPort.add(commPortIdentifier.getName());		        
		    }
		}	
		
		return listUSBPort;
	}
	
	/***
	 * Verifica se a lista com o nome das portas USB foram modificadas.
	 * @param listUSBPort Recebe como parâmetro uma lista de portas USB
	 * @return Retorna true caso as coleções sejam iguais, Caso contrário false.
	 */
	private boolean checksUSBPortChange(ArrayList<String> listUSBPort)
	{
		boolean change = false; 

		// Verifica se lista de portas USB atual tem os mesmos elementos e o mesmo tamanho.
		if (SerialPortIdentifiers.listUSBPort.containsAll(listUSBPort) && (SerialPortIdentifiers.listUSBPort.size() == listUSBPort.size()))
		{
			change = true;
		}
		
		return change;
	}
	
	/***
	 * Atualiza a lista de portas USB, caso tenha ocorrido alguma modificação.
	 * @param listUSBPort Lista com o nome das portas USB.
	 */
	private void updateUSBPort(ArrayList<String> listUSBPort){
		// Verifica se houve mudança nas portas USB conectadas.
		if (!checksUSBPortChange(listUSBPort)){
			// Limpa o conteúdo do Array
			SerialPortIdentifiers.listUSBPort.clear();
			// Adiciona a nova lista de Porta USB
			SerialPortIdentifiers.listUSBPort.addAll(listUSBPort);
		}
	}
	
	/***
	 * Método responsável por pegar a lista de portas atualizadas. 
	 */
	public void loadListUSBPort() {
		// Pega a coleção de portas USB
		ArrayList<String> listPortUSB = this.getPortIdentifiers();
		// Atualiza as lista de Portas USB.
		this.updateUSBPort(listPortUSB);		
	}		
}
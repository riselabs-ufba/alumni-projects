package generator;

import java.io.BufferedReader;

public class CallComands {

	public static void main(String[] args) {
		System.out.println("Começou");
		CallComands call = new CallComands();
	}
	
	public CallComands() {
		// TODO Auto-generated constructor stub
//		StringBuffer output = new StringBuffer();
		System.out.println("Chamou");
		String command = "/home/ramon/Downloads/apache/apache-karaf-4.0.8/bin/client start mqtt";

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			System.out.println("Foi!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

//		return output.toString();
	}

}

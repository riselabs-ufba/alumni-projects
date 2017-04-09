package usbListener;

public class TrataMensagem {

	private static String mensagem = null;
		
	public static String getMensagem(){
		return mensagem;
	}
	
	public TrataMensagem() {
		// TODO Auto-generated constructor stub
	}

	public static void tryReading(String message){
		if((message != null) && (message.length()>0)){
			if(message.startsWith("{") && (message.endsWith("}"))){
				message = message.replace("�", "").replace("\\0", "").trim();
				message = message.substring(0,message.lastIndexOf("}"));									
			}
		}
	}
	
	public static boolean tryReadingV(String message){
		boolean mensageValida = true;
		
		if((message != null) && (message.length()>0)){
			/*
			 * Se mensagem contem chaves abertas e fechadas
			 * Ela está bem formada(não foi quebrada)
			 * */
			if(message.contains("{") && message.contains("}")){
				message = message.trim();
				// extrai json.
				mensagem = message.substring(message.lastIndexOf("{"),message.lastIndexOf("}")+1);	
			}
			else {
				mensageValida = false;
			}
		}
				
		return mensageValida;
	}
}

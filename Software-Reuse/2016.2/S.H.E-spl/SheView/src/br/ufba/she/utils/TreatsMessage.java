package br.ufba.she.utils;

/**
 * Está classe tem como finalidade tratar e validar uma String no formato JSON.
 * @author Edilton
 */
public class TreatsMessage {
    private static String mensagem = null;
	
    /***
     * Método utilizado para pegar uma String JSON válida.
     * @return uma String JSON válida.
     */
    public static String getMessage(){
            return mensagem;
    }			

    /**
     * Méotodo responsável por tratar e validar as mensagens lidas no formato JSON.
     * @param message menssagem lida.
     * @return retorna true se s mensagem JSON for válida.
     */
    public static boolean tryReading(String message){
        boolean trueMessage = true;

        if((message != null) && (message.length()>0)){
                /*
                 * Se mensagem contem chaves abertas e fechadas
                 * Ela está bem formada(não foi quebrada)
                 * */
                if(message.contains("{") && message.contains("\"}")){
                    // Retira os espaço da mensagem.
                    message = message.trim();
                        // extrai json.
                    mensagem = message.substring(message.lastIndexOf("{"),message.lastIndexOf("}")+1);	
                }
                else {
                        trueMessage = false;
                }
        }

        return trueMessage;
    }
}

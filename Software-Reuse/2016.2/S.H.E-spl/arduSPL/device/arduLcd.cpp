#include "arduLcd.h"

ArduLcd::ArduLcd(){

}

void ArduLcd::setup(){
  // Inicializa LCD.
  lcd.begin(16,2);

  // Limpa o LCD.
  lcd.clear(); 
#ifdef temperature  
  // Cria o caractere customizado com o simbolo do grau no LCD.
  lcd.createChar(0, grau);
#endif  
}

void ArduLcd::lcdFailMessage(){
	// Limpa o LCD.
    lcd.clear();
    // Posiciona o cursor na coluna 0, linha 0.
    lcd.setCursor(0,0);
    // Envia o texto entre aspas para o LCD.
    lcd.print("Falha na leitura");
    // Posiciona o cursor na coluna 0, linha 1.
    lcd.setCursor(0,1);
    // Envia o texto entre aspas para o LCD.
    lcd.print("de dados!");
   
    if (Serial.available()){ //se byte pronto para leitura
       Serial.println("Falha na leitura de dados!"); 
    }
     
    return;
}

#ifdef luminosity
void ArduLcd::loop(int lumi){
  if (lumi == 0) {
    lcdFailMessage();
  }
    
  // Limpa o LCD.
  lcd.clear();
  
  // Posiciona o cursor na coluna 0, linha 0.
  lcd.setCursor(0,0);

  // Envia o texto entre aspas para o LCD.
  lcd.print("Luminosity: ");
  
  // Posiciona o cursor na coluna 0, linha 1. 
  lcd.setCursor(0,1);

  // Envia para o LCD o valor da luminosidade lido do sensor.
  lcd.print(lumi);
}
#endif

#if defined(presence) || defined(agua)
void ArduLcd::loop(char *message){
	// Limpa o LCD.
  lcd.clear();
  
  // Posiciona o cursor na coluna 0, linha 0.
  lcd.setCursor(0,0);

  // Envia a mensagem para o LCD.
  lcd.print(message);
}
#endif 

#ifdef gas
void ArduLcd::loop(char *message, int gasLevel){
	
  if (gasLevel == 0) {
    lcdFailMessage();
  }
  
	// Limpa o LCD.
  lcd.clear();
  
  // Posiciona o cursor na coluna 0, linha 0.
  lcd.setCursor(0,0);

  // Envia a mensagem para o LCD.
  lcd.print(message);
  
  // Posiciona o cursor na coluna 0, linha 1.
  lcd.setCursor(0,1);
  // Envia a mensagem para o LCD.
  lcd.print("Gas Level: ");
  // Posiciona o cursor na coluna 11, linha 1.
  lcd.setCursor(11,1);
  // Envia o  para o LCD.
  lcd.print(gasLevel);
}
#endif 

#ifdef temperature
void ArduLcd::loop(float umidade, float temperatura, float indiceCalor){
  if (isnan(umidade) || isnan(temperatura)) {
    lcdFailMessage();
  }
    
  // Início do bloco Temperatura - utilizado para escrever as informação da temperatura no LCD.
  // Limpa o LCD.
  lcd.clear();
  
  // Posiciona o cursor na coluna 0, linha 0.
  lcd.setCursor(0,0);

  // Envia o texto entre aspas para o LCD.
  lcd.print("Temp: ");
  
  //Posiciona o cursor na coluna 6, linha 0.
  lcd.setCursor(6,0);

  // Envia para o LCD o valor da temperatura lido do sensor.
  lcd.print(temperatura,1);
  
  // Posiciona o cursor na coluna 10, linha 0.
  lcd.setCursor(10,0);
 
  // Mostra o simbolo do grau formado pelo array, para isso é necessário 
  // fazer o cast de 0 para byte.
  lcd.write((byte)0);

  // Posiciona o cursor na coluna 11, linha 0.
  lcd.setCursor(11,0);

  // Envia o texto entre aspas para o LCD.
  lcd.print("C");
   // Fim do Bloco Temperatura. 

  // Início do bloco Umidade - utilizado para escrever as informação da umidade no LCD. 
  // Posiciona o cursor na coluna 0, linha 1. 
  lcd.setCursor(0,1);

  // Envia o texto entre aspas para o LCD.
  lcd.print("Umi:");

  //Posiciona o cursor na coluna 6, linha 1.
  lcd.setCursor(5,1);

  // Envia para o LCD o valor da Umidade lido do sensor.
  lcd.print(umidade,1);

  // Posiciona o cursor na coluna 10, linha 1.
  lcd.setCursor(9,1);

  // Envia para o LCD o simbolo %.
  lcd.print("%");

  // Posiciona o cursor na coluna 10, linha 1.
  lcd.setCursor(11,1);

  // Envia para o LCD o índice de calor.
  lcd.print("IC:");

  // Envia para o LCD o valor do índice de calor calculado.
  lcd.print(indiceCalor,1);  	
}
#endif
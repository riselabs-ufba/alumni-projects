#include "device.h"

#ifdef luminosity
int sensorPort = 5; // Pino analógico (A5) em que o sensor está conectado.
int readValue = 0; //Armazena valor lido do LDR
#endif

#ifdef presence
void ligarAlarme();
void desligarAlarme();
//Declaração das variáveis referentes aos pinos digitais.
#define pinBuzzer 7
#define pinSensorPIR 8
#define pinLed 9
int valorSensorPIR = 0;
bool detected = false;
#endif

#ifdef gas
#define sensorPort A0
#define nivel_sem_gas 300
int valor_analogico = 0;
#endif

#ifdef agua
#define sensorPort 8
int sensorData = 0;
int valor_analogico = 0;
#endif


void callback(char* topic, byte* payload, unsigned int length) {
  Serial.print("Message arrived [");
  Serial.print(topic);
  Serial.print("] ");
  for (int i=0;i<length;i++) {
    Serial.print((char)payload[i]);
  }
  Serial.println();
}

Device::Device(){
  	root["typeDevice"] = "Sensor";


#ifdef LCD	
	ardulcd.setup();
#endif

#ifdef luminosity
	root["name"] = "LuminositySensor";
	root["model"] = "LDR";
#endif
#ifdef temperature
	dht.begin();
	root["name"] = "TemperatureSensor";
	root["model"] = "DHT11";

#endif
#ifdef gas
	pinMode(sensorPort, INPUT);
	root["name"] = "GasSensor";
	root["model"] = "MQ2";
#endif	
#ifdef presence
	//Definido pinos como de entrada ou de saída
	pinMode(pinBuzzer,OUTPUT);
	pinMode(pinSensorPIR,INPUT);
	pinMode(pinLed,OUTPUT);
	root["name"] = "PresenceSensor";
	root["model"] = "PIR";
#endif
#ifdef agua
	pinMode(sensorPort, INPUT);
	root["name"] = "Water_sensor";  
  	root["model"] = "Funduino";
#endif

}

void Device::loop(){
 
 // temperature sensor
#ifdef temperature
  float umidade = dht.readHumidity(); 
  
  // Lê o valor da temperatura em Celsius (leitura padrão).
  float temperatura = dht.readTemperature();

  // Calcula o índice de calor em graus Celsius (Fahrenheit = false).
  float indiceCalor = dht.computeHeatIndex(temperatura, umidade, false);

  #ifdef LCD	
	ardulcd.loop(umidade,temperatura,indiceCalor);	
  #endif
  
  root["temperature"] = temperatura;  
  root["humidity"] = umidade;  
  root["heatIndex"] = indiceCalor; 
#endif

// luminosity sensor
#ifdef luminosity
   int readValue = analogRead(sensorPort); 
   root["luminosity"] = readValue;
  
  #ifdef LCD
	ardulcd.loop(readValue);
  #endif
#endif

// presence sensor
#ifdef presence
	//Lendo o valor do sensor PIR. Este sensor pode assumir 2 valores
	//1 quando detecta algum movimento e 0 quando não detecta.
   if (detected){
		ligarAlarme();
	}
	
	valorSensorPIR = digitalRead(pinSensorPIR);  	
	 
	//Verificando se ocorreu detecção de movimentos
	if (valorSensorPIR == 1) {	  			  
	  root["value'"] = "Tem alguem";
	  #ifdef LCD
		ardulcd.loop("Tem alguem");
	  #endif
	  detected = true;
	} else {
		desligarAlarme();
		root["value'"] = "Nao tem ninguem";
		#ifdef LCD
			ardulcd.loop("Nao tem ninguem");
		#endif
		detected = false;
	} 
	
#endif

// gas sensor
#ifdef gas
	int valor_analogico = 0;
	valor_analogico = analogRead(sensorPort);  
	root["GasLevel"] = valor_analogico;
	// Verifica o nível da concentração de gás.
  	if (valor_analogico > nivel_sem_gas){    
    	root["Info"] = "Gas detected.";   
		#ifdef LCD
			ardulcd.loop("Gas detected", valor_analogico);
		#endif
  	}else{
    	root["Info"] = "Gas not detected"; 
		#ifdef LCD
			ardulcd.loop("Gas not detected", valor_analogico);
		#endif
  	}
#endif

#ifdef agua
  	if( digitalRead(sensorPort) == HIGH) {      
      	sensorData = 1;
		
		root["value"] = "Water detected";  
		#ifdef LCD
			ardulcd.loop("Water detected");
		#endif
   	}else{
      	sensorData = 0;
		
		root["value"] = "Water undetected"; 
		#ifdef LCD
			ardulcd.loop("Water undetected");
		#endif
   	}
	
    if (sensorData == 1){    
    	
 	}else{
    	
 	}

#endif

#ifdef USB
   root.printTo(Serial);
#endif
   
}

#ifdef presence
void ligarAlarme() {
  //Ligando o led
  digitalWrite(pinLed, HIGH);
   
  //Ligando o buzzer com uma frequencia de 1500 hz.
  tone(pinBuzzer,1500);
   
  delay(4000); //tempo que o led fica acesso e o buzzer toca
   
  desligarAlarme();
}
 
void desligarAlarme() {
  //Desligando o led
  digitalWrite(pinLed, LOW);
   
  //Desligando o buzzer
  noTone(pinBuzzer);
}
#endif
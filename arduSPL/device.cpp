#include "device.h"

StaticJsonBuffer<200> jsonBuffer; // Buffer do JSON para transportar dados do sensor.
JsonObject& root = jsonBuffer.createObject(); // Criação do objeto JSON para transportar dados do sensor.

int sensorPort = 5; // Pino analógico (A5) em que o sensor está conectado.
int readValue = 0; //Armazena valor lido do LDR

Device::Device(){
	name = "LuminositySensor";
}

void Device::loop(){
	Serial.flush();
  	// Lê valor do sensor.
  	readValue = analogRead(sensorPort);
  
 	// Pega as propriedades do sensor.
   	// Monta o JSON com os dados do sensor.
	root["typeDevice"] = "Sensor";   
	root["name"] = name  
	root["model"] = "LDR";
	//Lendo o valor do sensor.
	root["value"] = readValue;
	root.printTo(Serial);
  
	Serial.println();
	delay(2000);
}
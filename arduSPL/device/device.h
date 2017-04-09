#include "flags.h"
#include "Arduino.h"
#include <ArduinoJson.h>


#ifdef temperature
#include <DHT.h>
// Define o pino de dados que será utilizado pelo sensor DHT11.
#define DHTPIN A5 
// Define o tipo de sensor DHT utilizado, nesse caso utilizaremos o DHT11.
#define DHTTYPE DHT11
static DHT dht(DHTPIN, DHTTYPE);
#endif

#ifdef LCD
#include "arduLcd.h"
static ArduLcd ardulcd;
#endif

#ifdef ethernet
#include <Ethernet.h>
#include <PubSubClient.h>
// Update these with values suitable for your network.
static byte mac[] = { 0x1E, 0xAD, 0xBE, 0xE2, 0xFE, 0xE5 };
static byte server[] = { 192, 168, 0, 138 };
static IPAddress ip(192, 168, 0, 196);
static EthernetClient ethClient;
void callback(char* topic, byte* payload, unsigned int length);
static PubSubClient client(server, 1883, callback , ethClient);
#endif

// static StaticJsonBuffer<512> jsonBuffer; // Buffer do JSON para transportar dados do sensor.
// static JsonObject& root = jsonBuffer.createObject(); // Criação do objeto JSON para transportar dados do sensor.

// void montaJson(float temperatura, float umidade, float indiceCalor);

class Device{
public:

	StaticJsonBuffer<512> jsonBuffer; // Buffer do JSON para transportar dados do sensor.
	JsonObject& root = jsonBuffer.createObject(); // Criação do objeto JSON para transportar dados do sensor.

	#ifdef ethernet
	#endif

	Device();
	void setup();
	void loop();	
	void montaJson();
	// String name;
};
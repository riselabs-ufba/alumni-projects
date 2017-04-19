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
	#ifdef luminosity
		static byte mac[] = { 0x1E, 0xAD, 0xBE, 0xE2, 0xFE, 0xE5 };
		static IPAddress ip(192, 168, 0, 196);
	#endif
	
	#ifdef gas
		static byte mac[] = { 0x2E, 0xAD, 0xBE, 0xE1, 0xFE, 0xE6 };
		static IPAddress ip(192, 168, 0, 195);
	#endif
	
	#ifdef presence
		static byte mac[] = { 0x3E, 0xAD, 0xBE, 0xE3, 0xFE, 0xE4 };
		static IPAddress ip(192, 168, 0, 194);
	#endif
	
	#ifdef agua
		static byte mac[] = { 0x4E, 0xAD, 0xBE, 0xE4, 0xFE, 0xE3 };
		static IPAddress ip(192, 168, 0, 193);
	#endif
	
	#ifdef temperature
		static byte mac[] = { 0x5E, 0xAD, 0xBE, 0xE5, 0xFE, 0xE2 };
		static IPAddress ip(192, 168, 0, 192);
	#endif

// Ip do sevidor MQTT.	
static byte server[] = { 192, 168, 0, 138 };
static EthernetClient ethClient;
void callback(char* topic, byte* payload, unsigned int length);
static PubSubClient client(server, 1883, callback , ethClient);
#endif

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
};
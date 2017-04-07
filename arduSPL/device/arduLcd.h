#include <LiquidCrystal.h>
#include "Arduino.h"

static LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

// Array utilizado para criar simbolo (º) grau.
static byte grau[8] ={ B00001100,
                B00010010,
                B00010010,
                B00001100,
                B00000000,
                B00000000,
                B00000000,
                B00000000,};

class ArduLcd{
public:
	ArduLcd();

	void setup();
	void loop(float, float, float);
	
};                
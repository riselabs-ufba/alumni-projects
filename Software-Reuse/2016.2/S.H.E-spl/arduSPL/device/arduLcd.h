#include <LiquidCrystal.h>
#include "Arduino.h"
#include "flags.h"

static LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

#ifdef temperature
// Array utilizado para criar simbolo (º) grau.
static byte grau[8] ={ B00001100,
                B00010010,
                B00010010,
                B00001100,
                B00000000,
                B00000000,
                B00000000,
                B00000000,};

#endif				
				
class ArduLcd{
public:
	ArduLcd();

	void setup();
	
	void lcdFailMessage();
	
	#ifdef luminosity		
		void loop(int);
	#endif
	
	#if defined(presence) || defined(agua)
		void loop(char*);
	#endif	
	
	#ifdef gas
		void loop(char*, int);
	#endif	
	
	#ifdef temperature
		void loop(float, float, float);
	#endif
	
};                
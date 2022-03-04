#include <Servo.h>
int inByte =0,b=1, b1=2, b2=3, c=4, m=5,p=6;
int pos1[] = {b, b1, b2, c, m,p};
int pos2[] = {b, b1, b2, c, m,p};
Servo servo1;
Servo servo2;
Servo servo3;
Servo servo4;
Servo servo5;
Servo servo6;



void setup()
{
 Serial.begin(9600);//Configuracion velocidad
 servo1.attach(9);//Motor base 1 angulo 130
 servo2.attach(10); //Motor Base 2 angulo 50
 servo3.attach(11);//Motor 3 codo 
 servo4.attach(3);//Motor Base giratoria
 servo5.attach(5);//Motor muñeca
 servo6.attach(6);//Pinza
 
}

void loop()
{
  //servo1.write(90);
  //servo2.write(90);
  servo3.write(90);
  //servo4.write(90);
  //servo5.write(90);
  //servo6.write(90);
  delay(15);
  
}
void serialEvent() {
  while (Serial.available()>0) {
   inByte = Serial.read();
   if(inByte == 1)
   {
    servo1.write(130);
    servo2.write(50);
    servo3.write(90);
    servo4.write(90);
    servo5.write(90);
    servo6.write(60);
    delay(15); 
   }
   if(inByte == 3)//Posicion 1
   {
    for(int i=0;i<6;i++)
    {
     inByte = Serial.read();
     pos1[i]=inByte;//Almacena datos de la posicon 1, ya sea de la aplicacion o de los motores
     delay(200);
     Serial.print(1);//Imprime en consola,(solamente para propositos de verificacion, se puede omitir)
     
    }
   }
   if(inByte == 4)//Posicion 2
   {
    for(int i=0;i<6;i++)
    {
     inByte = Serial.read();
     pos2[i]=inByte;//Almacena datos de la posicon 2, ya sea de la aplicacion o de los motores
     delay(200);
     Serial.print(1);//Imprime en consola,(solamente para propositos de verificacion, se puede omitir)
     
    }
   }
   if(inByte == 6)//Posicion 2
   {
    while(true)
   { 
    servo1.write(pos1[2]);
    delay(1000);
    servo2.write(pos1[1]);
    delay(1000);
    servo3.write(pos1[3]);
    delay(1000);
    servo4.write(pos1[0]);
    delay(1000);
    servo5.write(0);
    delay(1000);
    servo6.write(45);
    delay(15);
    delay(2000);
    servo1.write(pos2[2]);
    delay(1000);
    servo2.write(pos2[1]);
    delay(1000);
    servo3.write(pos2[3]);
    delay(1000);
    servo4.write(pos2[0]);
    delay(1000);
    servo5.write(60);
    delay(1000);
    servo6.write(45);
    delay(15);
   }
   }
   if(inByte == 7)
   {
    servo1.write(90);
    servo2.write(90);
    servo3.write(90);
    servo4.write(90);
    servo5.write(90);
    servo6.write(0);
    delay(15); 
   }
 }
}
   
    
    

  



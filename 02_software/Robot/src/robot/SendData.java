/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import java.awt.Graphics;

/**
 *
 * @author Familia
 */
public class SendData  {
    private static Communication g = new Communication();
    private int vector[]= new int[6]; //Vector almacena angulos   
    private int x ,y;
    public SendData(){
        
    }
    public void Recived(int c,int data){
        
        vector[c] = data;//Recive datos al recibir instruccion de la interfaz
    }
    public void sendToArduino()
    {
        
          // for(int i=0;i<=5;i++){
            g.sendData(90/*vector[i]*/);//Envia datos
            g.reciveData();//Espera confirmacion arduino
       // }
    }
    public void print(){//Prueba en consola
        for(int i=0;i<=5;i++){
            System.out.println(vector[i]);//Imprime en consola
        }
    }
    public static void DraLine(Graphics g,int x, int y, int x1, int y1){
        g.drawLine(x1, y1, x1, y1);
    }
  
     public void SetX(int X1){
        
         x=X1;
    }
    public void SetY(int Y1){
        
         y=Y1;
    }
      public int coordenadaX(){
        
        return x;
    }
    public int coordenadaY(){
        
        return y;
    }
}
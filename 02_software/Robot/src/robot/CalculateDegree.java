/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;
import java.lang.Math.*;

/**
 *
 * @author Familia
 */
public class CalculateDegree {
    private int x,y,z,L1=195,L2=160;
    public static float h,r,q1,q2,q3,q4,A,B,alfa,betta,x_cal_f,y_cal_f,x_cal,y_cal;
   
    

    public CalculateDegree() {
       
        
        this.z=125;
    }
    public void setXY(int getX, int getY)
    {
        x = getX;
        y = getY;
        x_cal = x - 250;
        y_cal = 500 -y;
    }
    public float scalaX_cal(){
        x_cal_f = (float) (0.6*x_cal);
        return x_cal_f;
    }
     public float scalaY_cal(){
        y_cal_f = (float) (0.6*y_cal);
        return y_cal_f;
    }
    public void CalcularPos(){
        float s,t,u,v,w;
        
        s = (float) Math.atan((scalaY_cal()/scalaX_cal()));
        t =  (float) Math.toDegrees(s);
        if(t<0){
            q1 = 180 + t;
            
        }
        else{
            q1=t;
        }
        //Calculo angulo q3
        r = (float) Math.sqrt(Math.pow(scalaX_cal(), 2)+Math.pow(scalaY_cal(), 2));
        h = (float) Math.sqrt(Math.pow(r,2)+Math.pow(z, 2));
        u = (float) Math.acos(((Math.pow(L1, 2)+Math.pow(L2,2)- Math.pow(h,2))/(2*(L1*L2))));
        q3 = (float) Math.toDegrees(u);
        //Calculo anculo q2
        v = (float) Math.acos(((Math.pow(L1, 2)+Math.pow(h,2)- Math.pow(L2,2))/(2*(L1*h))));
        A = (float) Math.toDegrees(v);
        w = (float) Math.atan((z/r));
        B = (float) Math.toDegrees(w);
        q2 = A + B;
        //Calculo de angulo q4
        alfa = 180 - (A+q3);
        betta =180 - (90 + B);
        q4 = alfa + betta;
           
    }
    
    public float getQ1() {
        return q1;
    }

    public float getQ2() {
        return q2;
    }

    public float getQ3() {
        return q3;
    }

    public float getQ4() {
        return q4;
    }
    public void imprimir(){
     System.out.print(q1+" "+q2+" "+q3+" "+q4);
    }

    
}

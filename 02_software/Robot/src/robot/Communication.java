/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

/**
 *
 * @author Familia
 */
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Enumeration;
 
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Communication extends JPanel{
    
    private OutputStream output = null;
    private InputStream intput = null;
    private JFrame frame;
    private int r ;
    
    SerialPort serialPort;
    private final String PORT_NAME = "COM4";
    /** Milliseconds to block while waiting for port open */
    private static final int TIME_OUT = 2000;
    /** Default bits per second for COM port. */
    private static final int DATA_RATE = 9600;
    
    public void initializeArduinoConnection(){
 
        CommPortIdentifier portId = null;//
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
 
        // iterate through, looking for the port
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier)
                    portEnum.nextElement();
 
            if (PORT_NAME.equals(currPortId.getName())) {
                portId = currPortId;
                break;
            }
        }
 
        if (portId == null) {
            showError("Could not find COM port.");
            //System.exit(ERROR);
            return;
        }
 
        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);
 
            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
 
            // open the streams
            output = serialPort.getOutputStream();
            intput = serialPort.getInputStream();
            showSuccessful("Done");
 
        } catch (Exception e) {
            showError(e.getMessage());
           // System.exit(ERROR);
        }
 
    }
     private void showError(String errorMessage){
        JOptionPane.showMessageDialog(frame,
                errorMessage,
                "Error",
                JOptionPane.ERROR_MESSAGE);
                estado(1);
    }
    private void showSuccessful(String Successfull){
        JOptionPane.showMessageDialog(frame,
                Successfull,
                "Message",
                JOptionPane.INFORMATION_MESSAGE);
                estado(2);
        
    } 
     public void sendData(int data){
 
        try {
            System.out.print(data);
            output.write(data);
        } catch (IOException e) {
            showError("Error sending data");
           // System.exit(ERROR);
        }
    }
     
    public void reciveData()
    {
        //System.out.print("1");
        int line=0;
        try{
          //intput.available()>0
            while(intput.available()>0){
               
                line = intput.read();
                
                intput.close();
                System.out.print(line-48);
                
                
                
          }
           
        }catch(IOException e){
            showError("Could not get data");
        }
        
    }
    public void estado(int s)
    {       
        r = s;       
    }
    public int getStado()
    {       
        return r;
    }
    
    
}

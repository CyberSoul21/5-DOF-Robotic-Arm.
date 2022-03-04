/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 *
 * @author Familia
 */
public class Window3 extends javax.swing.JDialog{

    /**
     * Creates new form Window3
     */
     
    private int b=0, b1=0, b2=0, c=0, m=0, p=0,sec;//Motores
     private int b_2=0, b1_2=0, b2_2=0, c_2=0, m_2=0, p_2=0;
    CalculateDegree gr = new  CalculateDegree();
   
    private static final Window1 w = new Window1();
     //private static final PanelFondo f = new PanelFondo();
    private Window1 padre = (Window1)this.getParent();
    public Window3(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        PanelFondo f = new PanelFondo();
        this.add(f,BorderLayout.CENTER);
        this.pack();
        
        
    }
    public void setFieldText(){//Coloca los valores del campo de texto en CERO
         jTextField1.setText("0"); 
               
         
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aplicación: \"Pick and Place\" ");
        setResizable(false);

        jButton1.setText("Posición 1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Posicion 2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Número de veces:");

        jButton3.setText("Cargar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(513, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jButton3)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        //
       w.Command(3);
       jButton2.setEnabled(true);
       b =  (int)gr.getQ1(); //Convierte datos String decimales en enteros
       b1 = (int)gr.getQ2(); 
       b2 = (int)gr.getQ2(); 
       c =  (int)gr.getQ3(); 
       m =  (int)gr.getQ4(); 
       p =  (int)gr.getQ4(); 
       b2=180-b2;
       int vec[]={b,b1,b2,c,m,p,};
        for(int i=0;i<=5;i++){
        w.Recived(i, vec[i]);
             //Envia datos a clase principal           
        }
        w.LoadData();
       // System.out.print(" "+b+" ");
        jButton1.setEnabled(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       w.Command(4);
       jButton1.setEnabled(true);
       b_2 =  (int)gr.getQ1(); //Convierte datos String decimales en enteros
       b1_2 = (int)gr.getQ2(); 
       b2_2 = (int)gr.getQ2(); 
       c_2 =  (int)gr.getQ3(); 
       m_2 =  (int)gr.getQ4(); 
       p_2 =  (int)gr.getQ4();
       sec =  (int)Float.parseFloat(jTextField1.getText()); 
       b2_2=180-b2_2;
       int vec[]={b_2,b1_2,b2_2,c_2,m_2,p_2,};
        for(int i=0;i<=5;i++){
         w.Recived(i, vec[i]);
             //Envia datos a clase principal           
        }
        w.LoadData();
        //System.out.print(" "+b+" ");
        jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        w.Command(5);
        jTextField1.setEnabled(false);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        
         
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

   
}

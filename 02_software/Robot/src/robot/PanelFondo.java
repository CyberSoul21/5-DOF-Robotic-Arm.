/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Familia
 */
public class PanelFondo extends javax.swing.JPanel {

    /**
     * Creates new form PanelFondo
     */
   

    private int x, y;
    
    CalculateDegree gr = new  CalculateDegree();
    public PanelFondo() {
        initComponents();
        this.setSize(500,500);
        
    }
     public void paintComponent(Graphics g){
        Dimension tam = getSize();
        ImageIcon ImagenFondo = new ImageIcon(new ImageIcon(getClass().getResource("/robot/Imagen.jpg")).getImage());
        g.drawImage(ImagenFondo.getImage(), 0, 0, tam.width,tam.height,null);
        setOpaque(false);
        super.paintComponents(g);
        
       
        
    }

    public int getX(){//Esto va para la clase que calcula angulos
        
        return x;
    }
     public int getY(){
        
        return y;
    }
    
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
       //CalculateDegree gr = new  CalculateDegree();
         x = evt.getX();
         y = evt.getY();
         gr.setXY(x, y);
         gr.CalcularPos();
        // gr.imprimir();
                 
         
         
         
       
        
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

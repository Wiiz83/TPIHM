/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.ex1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.SwingUtilities;


/**
 *
 * @author uzanl
 */
public final class Exercice1 extends javax.swing.JFrame implements MouseListener, MouseMotionListener {

    public enum Etat {StandBy, Drawing};
    public Etat etat;
    
    public Exercice1() {
        initComponents();
        aireDeDessin1.addMouseListener(this);
        aireDeDessin1.addMouseMotionListener(this);
        etat = Etat.StandBy;
        presentationStandBy();
    }
    
    //
    public void presentationStandBy() {
        
    }
    
    //
    public void presentationDrawing() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aireDeDessin1 = new tp4.ex1.AireDeDessin();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout aireDeDessin1Layout = new javax.swing.GroupLayout(aireDeDessin1);
        aireDeDessin1.setLayout(aireDeDessin1Layout);
        aireDeDessin1Layout.setHorizontalGroup(
            aireDeDessin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );
        aireDeDessin1Layout.setVerticalGroup(
            aireDeDessin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aireDeDessin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aireDeDessin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Exercice1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exercice1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exercice1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exercice1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exercice1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tp4.ex1.AireDeDessin aireDeDessin1;
    // End of variables declaration//GEN-END:variables



    @Override
    public void mousePressed(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e)){
            switch(etat){
                case StandBy :
                    etat = Etat.Drawing;
                    aireDeDessin1.setOrigin(e.getPoint());
                    break;
                case Drawing :
                    break;
            }
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        switch(etat){
                case StandBy :

                    break;
                case Drawing :
                    aireDeDessin1.drawPreview(e.getPoint());
                    break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch(etat){
                case StandBy :

                    break;
                case Drawing :
                    etat = Etat.StandBy;
                    aireDeDessin1.drawFinish();
                    break;
        }
    }
    
 

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    
    }
}

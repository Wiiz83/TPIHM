/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.ex2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author uzanl
 * 
 * 
 * Exercice 2 : Editeur de polygones (polyline)
On souhaite concevoir et développer un éditeur de polygones à manipulation directe.
L’utilisateur doit pouvoir effectuer les manipulations suivantes :
    - Un clic gauche
        o ajoute un point s’il n’y a aucun premier point pour le polygone  OK
        o affiche le tracé définitif de la ligne entre le point précédent et le point où vient d’être effectué le clic  OK
    - Un déplacement de souris affiche le tracé temporaire partant du dernier point  OK
    - Un clic droit enlève le dernier point ajouté (excepté le cas où il n’y a qu’un point)
    - Un appui sur la touche espace termine la forme courante  OK

Appliquer la démarche de conception d’un système interactif étudiée en cours pour développer une
cette application
 * 
 */
public class Exercice2 extends javax.swing.JFrame {

    /**
     * Creates new form Exercice2
     */
    public Exercice2() {
        initComponents();
        
        EcouteurDeSouris listener = new EcouteurDeSouris(aireDeDessin1);
        EcouteurDeComposant component_listener = new EcouteurDeComposant(aireDeDessin1);

        aireDeDessin1.addComponentListener(component_listener);
        aireDeDessin1.addMouseListener(listener);
        aireDeDessin1.addMouseMotionListener(listener);

        
        KeyAdapter ka = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // figure terminée !
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                   aireDeDessin1.drawFinish();
                }    
            } 
        };
        
        addKeyListener(ka);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aireDeDessin1 = new tp4.ex2.AireDeDessin();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout aireDeDessin1Layout = new javax.swing.GroupLayout(aireDeDessin1);
        aireDeDessin1.setLayout(aireDeDessin1Layout);
        aireDeDessin1Layout.setHorizontalGroup(
            aireDeDessin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        aireDeDessin1Layout.setVerticalGroup(
            aireDeDessin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aireDeDessin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aireDeDessin1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Exercice2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exercice2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exercice2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exercice2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exercice2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tp4.ex2.AireDeDessin aireDeDessin1;
    // End of variables declaration//GEN-END:variables
}

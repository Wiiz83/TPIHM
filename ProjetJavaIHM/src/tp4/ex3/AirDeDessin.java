/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.ex3;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import tp4.Forme;

public class AirDeDessin extends javax.swing.JPanel {

    final ArrayList<Forme> formes = new ArrayList<>();
    BufferedImage mon_image;
    Graphics2D graphic;
    Point origin;
    Point destination;
    int width;
    int height;
    Forme formeEnCours;
    Forme.Type type;
    
    
    public AirDeDessin() {
        initComponents();
        mon_image = null;
        origin = null;
    }
    
    public void setOrigin(Point p) {
        origin = p;
    }

    public void drawPreview(Point p) {
        formeEnCours = new Forme(origin.x, origin.y, p.x, p.y, type);
        graphic.setPaint(Color.white);
        graphic.fillRect(p.x, p.y, 10, 10);
        repaint();
    }
    
    public void drawFinish(){
        formes.add(this.formeEnCours);        
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {       
        super.paintComponent(g);
        Graphics2D drawable = (Graphics2D) g;

        // On reccupere quelques infos
        int width = getSize().width;
        int height = getSize().height;

        // on efface tout les dessins
        mon_image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphic = mon_image.createGraphics();
        graphic.setPaint(Color.white);
        graphic.fillRect(0, 0, width, height);
        graphic.setPaint(Color.black);
       
        if(formeEnCours != null){
            if(type == Forme.Type.Ligne){
                graphic.drawLine(formeEnCours.x1, formeEnCours.y1, formeEnCours.x2, formeEnCours.y2);
            }

            if(type == Forme.Type.Cercle){
                graphic.drawOval(formeEnCours.x1, formeEnCours.y1, formeEnCours.x2, formeEnCours.y2);
            }

            if(type == Forme.Type.Rectangle){
                graphic.drawRect(formeEnCours.x1, formeEnCours.y1, formeEnCours.x2, formeEnCours.y2);
            }
        }
        

        // et toutes les lignes terminées
        if(formes.size() > 0){
            for(Forme laforme : formes) {
                switch(laforme.type){
                    case Ligne :
                        graphic.drawLine(laforme.x1, laforme.y1, laforme.x2, laforme.y2);
                        break;
                    case Cercle :
                        graphic.drawOval(laforme.x1, laforme.y1, laforme.x2, laforme.y2);
                        break;
                    case Rectangle :
                        graphic.drawRect(laforme.x1, laforme.y1, laforme.x2, laforme.y2);
                        break;
                }
            } 
        }

        drawable.drawImage(mon_image, 0, 0, null);
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Première utilisation de la méthode paint()
 *
 * Dessiner une ellipse et ses axes principaux dans un JPanel
 *
 */
public class paint extends JPanel{

    public void paint(Graphics g){

        // Choix de la couleur
        g.setColor(Color.lightGray);
        // On dessine tout le fond
        g.fillRect(0,0,getWidth(),getHeight());
        // On change la couleur
        //g.setColor(Color.magenta);
        // On récupère le centre de la Frame
        //int xC=getWidth()/2;
        //int yC=getHeight()/2;
        // On dessine une ellipse au milieu
        //g.fillOval(xC-200,yC-100,400,200);
        // On change la couleur
        g.setColor(Color.black);
        // On dessine les axes de l'ellipse
        for (int i=0;i<(getWidth());i++) {
            g.drawLine((100 * i), 0, (100*i), getHeight());
            g.drawLine(0, (100*i), getWidth(), (100*i));
        }
        // On écrit du texte
        //g.setColor(Color.blue);
        //Font police = new Font("Courier",Font.BOLD,20);
        //g.setFont(police);
        //nt HauteurTexte = getFontMetrics(police).getHeight();
        //g.drawString("Voici un petit texte",0,HauteurTexte);

    }

}

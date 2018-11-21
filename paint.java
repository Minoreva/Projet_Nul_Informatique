import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class paint extends JPanel{
    Master[][] tablo;

    public paint(Master[][] tablo){
        this.tablo = tablo;

    }
    public void paint(Graphics g){
        // Choix de la couleur
        g.setColor(Color.lightGray);
        // On dessine tout le fond
        g.fillRect(0,0,getWidth(),getHeight());



        for (int i = 0; i < tablo.length; i++) {
            for (int k = 0; k < tablo.length; k++) {
                if(tablo[i][k].getVie() == 1) {
                    //Création d'une citrouille aléatoirement
                    g.setColor(Color.ORANGE);
                    g.fillOval(25+(i*100),25+(k*100),50,50);
                } else if (tablo[i][k].getVie() == 2){
                    g.setColor(Color.RED);
                    g.fillOval(25+(i*100),25+(k*100),50,50);
                }
            }
        }


        // Création d'un lapin aléatoirement

        //int e = (int)(Math.random()*(5));
        //int v = (int)(Math.random()*(5));


        // On change la couleur
        g.setColor(Color.black);

        // On dessine les colonnes et les lignes
        for (int i=0;i<(getWidth());i++) {
            g.drawLine((100 * i), 0, (100*i), getHeight());
            g.drawLine(0, (100*i), getWidth(), (100*i));
        }
    }


}
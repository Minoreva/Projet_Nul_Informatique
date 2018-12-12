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
                if(tablo[i][k] != null) {
                    if (tablo[i][k].getVie() == 1) {
                        g.setColor(Color.orange);
                        g.fillRect((i * 10), (k * 10), 10, 10);
                    } else if (tablo[i][k].getVie() == 2) {
                        g.setColor(Color.RED);
                        g.fillRect((i * 10), (k * 10), 10, 10);
                    }                    
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
            g.drawLine((10 * i), 0, (10*i), getHeight());
            g.drawLine(0, (10*i), getWidth(), (10*i));
        }
    }
}

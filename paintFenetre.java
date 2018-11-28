import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Première utilisation de la méthode paint()
 *
 * Dessiner une fonction avec un JPanel personnalisé
 *
 */
public class paintFenetre extends JFrame{



    public paintFenetre() {






        // paramètre de la fenêtre
        setTitle("essai");
        setLayout(null);


        // dimensionnement de la fenêtre
        setSize(500, 500);
        setLocation(300, 200);

        // quitter le programme lorsqu'on ferme la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        Master tablo[][] = new Master[50][50];
        int chance=0;

        for (int i = 0; i < tablo.length; i++) {
            for (int k = 0; k < tablo.length; k++) {
                    tablo[i][k] = new Master(i,k,0,0);
                    tablo[i][k].SpawnVie();
                    if(tablo[i][k].getVie() == 0){
                        tablo[i][k] = null;

                    }

            }
        }


        Timer timer1;
        class ReactionTopTimer implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                // ici le code qui sera appele a chaque top du timer
                ;
                for (int i = 0; i < tablo.length; i++) {
                    for (int k = 0; k < tablo.length; k++) {
                        if (tablo[i][k] != null) {
                            tablo[i][k].isDeplaced=false;
                        }
                    }
                }

                for (int i = 0; i < tablo.length; i++)
                    for (int k = 0; k < tablo.length; k++)
                        if (tablo[i][k] != null) {
                            if (tablo[i][k].isDeplaced == false) {
                                tablo[i][k].isDeplaced = true;
                                tablo[i][k].déplacer(tablo);
                            }
                        }
                repaint();
            }
        }

        timer1 = new Timer(100, new ReactionTopTimer());




        JPanel drawingPanel = new paint(tablo);
        setContentPane(drawingPanel);

        //repaint();


        timer1.start(); // lance le timer
        setVisible(true);
    }




}


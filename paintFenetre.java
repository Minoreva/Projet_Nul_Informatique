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

        //tableau();

        // dimensionnement de la fenêtre
        setSize(600, 600);
        setLocation(300, 200);

        // quitter le programme lorsqu'on ferme la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // On utilise un drawingPanel



        Master tablo[][] = new Master[5][5];
        int chance=0;

        for (int i = 0; i < tablo.length; i++) {
            for (int k = 0; k < tablo.length; k++) {
                tablo[i][k] = new Master(i,k,0,0);
                tablo[i][k].SpawnVie();
            }
        }


        JPanel boutonPane = new JPanel();
        JButton bouton = new JButton("Bouger");
        bouton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                for (int i = 0; i < tablo.length; i++) {
                    for (int k = 0; k < tablo.length; k++) {
                        tablo[i][k].déplacer(tablo);
                        repaint();
                    }
                }
            }
        });

        Timer timer1;
        class ReactionTopTimer implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                // ici le code qui sera appele a chaque top du timer
                ;
                for (int i = 0; i < tablo.length; i++) {
                    for (int k = 0; k < tablo.length; k++) {
                        tablo[i][k].déplacer(tablo);
                        repaint();
                    }
                }

            }
        }
        timer1 = new Timer(500, new ReactionTopTimer());




        JPanel drawingPanel = new paint(tablo);
        setContentPane(drawingPanel);
        boutonPane.add(bouton);
        this.getContentPane().add(boutonPane, BorderLayout.NORTH);
        //todo : Faire un tableau qui créera a chaque boucle le lapin et la citrouille pour les faire ses déplacer
        //repaint();


        timer1.start(); // lance le timer
        setVisible(true);
    }




}


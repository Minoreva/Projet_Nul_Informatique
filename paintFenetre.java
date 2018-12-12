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
int nbLapins = 0;
int nbPotirons = 0;
    public paintFenetre() {
        // paramètre de la fenêtre
        setTitle("essai");
        setLayout(null);


        // dimensionnement de la fenêtre
        setSize(500, 500);
        setLocation(300, 200);

        // quitter le programme lorsqu'on ferme la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        Master tablo[][] = new Master[50][50]; // Arbitrairement je me contenterai d'un tableau 50*50 pour l'instant.

        for (int i = 0; i < tablo.length; i++) { //Boucle qui fabrique le premier jet du tableau
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
            public void actionPerformed(ActionEvent Licorne_Fabuleuse) {
                // ici le code qui sera appele a chaque top du timer
                for (int i = 0; i < tablo.length; i++) {
                    for (int k = 0; k < tablo.length; k++) {
                        if (tablo[i][k] != null) {
                            tablo[i][k].isDeplaced = false;
                            if (tablo[i][k].getVie() == 1)  //compte les lapins
                                nbLapins++;
                            if (tablo[i][k].getVie() == 2) //compte les potirons
                                nbPotirons++;
                        }
                    } // On note master.vie == 1 => Lapin et master.vie == 2 => Potiron
                }
                for (int i = 0; i < tablo.length; i++) {
                    for (int k = 0; k < tablo.length; k++) {
                        if(tablo[i][k] == null){
                            tablo[i][k] = new Master(i,k,0,0); // Génère la vie et le spawn de potirons.
                            if(tablo[i][k].getVie() == 0) // vérifie si un potiron ou un lapin est né sur une case. Semble bug sur le spawn potiron
                                tablo[i][k] = null;
                        }
                    }
                }
                
                for(int i=0;i < ((3*nbLapins)/(nbPotirons+1)); i++){
                int a = (int) (Math.random() * (50));
                int b = (int) (Math.random() * (50));
                if(tablo[a][b] == null)
					tablo[a][b] = new Master(a,b,0,2); //Potiron
				}
				for(int i=0;i < ((nbPotirons)/(nbLapins+1)); i++){
                int a = (int) (Math.random() * (50));
                int b = (int) (Math.random() * (50));
                if(tablo[a][b] == null)
					tablo[a][b] = new Master(a,b,0,1); // Lapin
				}
				
                
                
                System.out.println(nbLapins +"   "+nbPotirons); // message de debug

                for (int i = 0; i < tablo.length; i++) {
                    for (int k = 0; k < tablo.length; k++) {
                        if (tablo[i][k] != null) {
                            if (tablo[i][k].isDeplaced == false) {
                                tablo[i][k].isDeplaced = true;
                                tablo[i][k].tour++;
                                tablo[i][k].MeurtreMortDetruire(tablo); //tue les lapins dépassant 'x' tours
                                if(tablo[i][k].inBoundsmiam())
                                  tablo[i][k].Manger(tablo,nbLapins,nbPotirons); //scan + mange lapins
                                if(tablo[i][k] != null && tablo[i][k].inBounds())
                                    tablo[i][k].déplacer(tablo); // déplace lapin ; bug sur les bordures ?
                            }
                        }
                    }
                }
                nbPotirons=0;
                nbLapins=0;
                repaint();
            }
        }

        timer1 = new Timer(150, new ReactionTopTimer());

        JPanel Poney_enragé_DrawingPane = new paint(tablo);
        setContentPane(Poney_enragé_DrawingPane);

        timer1.start(); // lance le timer
        setVisible(true);
    }

}


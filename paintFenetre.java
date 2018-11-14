import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
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
        setSize(600, 600);
        setLocation(300,200);

        // quitter le programme lorsqu'on ferme la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // On utilise un drawingPanel
        JPanel drawingPanel = new paint();
        setContentPane(drawingPanel);

        setVisible(true);
    }
}


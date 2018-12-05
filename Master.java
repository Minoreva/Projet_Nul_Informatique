import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Master {
    public int x;
    public int y;
    public double poids;
    public int vie;
    boolean isDeplaced;
    public int tour;

    public Master(int x, int y, double poids,int vie) {
        this.x = x;
        this.y = y;
        this.poids = poids;
        this.vie = vie;
        this.isDeplaced = false;
        this.tour = 0;
    }

    public void setMort(){
        this.vie = 0;

    }

    public void SpawnVie() {
        int chance = (int) (Math.random() * (100));
        if (chance > 95)
            this.vie = 1;
        else if (chance < 5)
            this.vie = 2;
    }

    public int getVie(){
            return this.vie;
    }

    public void déplacer(Master[][] tablo) {
        try {
            if (this.getVie() == 1 && tablo[x][y] != null) { //todo : les règles de locta voltera
                int déplacement = (int) (Math.random() * (5));
                //int déplacement = 1;
                if ((déplacement == 1 && (x > 0 && y > 0)) && (tablo[x - 1][y - 1] == null)) {
                    tablo[x - 1][y - 1] = tablo[x][y];
                    tablo[x][y] = null;
                    x = x - 1;
                    y = y - 1;
                }
                if ((déplacement == 2 && (x > 0 && y < 50)) && (tablo[x - 1][y + 1] == null)) {
                    tablo[x - 1][y + 1] = tablo[x][y];
                    tablo[x][y] = null;
                    x = x - 1;
                    y = y + 1;
                }
                if ((déplacement == 3 && (x < 50 && y < 50)) && (tablo[x + 1][y + 1] == null)) {
                    tablo[x + 1][y + 1] = tablo[x][y];
                    tablo[x][y] = null;
                    x = x + 1;
                    y = y + 1;
                }
                if ((déplacement == 4 && (x < 50 && y > 0)) && (tablo[x + 1][y - 1] == null)) {
                    tablo[x + 1][y - 1] = tablo[x][y];
                    tablo[x][y] = null;
                    x = x + 1;
                    y = y - 1;
                }

                // tant qu'à faire, on mange pendant qu'on se déplace... On pourra la mettre en méthode à part entière plus tard. G la flem
                for(int i=-1;i<=1;i++){
                    for(int k=-1;k<=1;k++){
                        if (tablo[x+i][y+i] != null && tablo[x+i][y+i].getVie() == 2){
                            tablo[x+i][y+i] = null;
                            if((int)(Math.random() * (100)) < 15)
                                tablo[x+i][y+i] = new Master(x+i,y+i,0,1);
                        }
                    }
                }
            }
        } catch(ArrayIndexOutOfBoundsException f){

        }
    }

    public void SpawnPot(int nbLap, int nbPot){
        int chance = (int) (Math.random() * (100));
        if (chance > 50 && (nbLap > 2*nbPot))
            this.vie = 2;
    }

    public void MeurtreMortDetruire(Master[][] tablo){
        if ( tour == 275 )
            tablo[x][y].setMort();
    }

}

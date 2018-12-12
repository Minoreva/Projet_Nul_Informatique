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

    public void déplacer(Master[][] tablo) { // Les points en bordure et/ou entourés ne semblent plus bouger à partir d'un certain moment.
        if (this.getVie() == 1 && tablo[x][y] != null) { //todo : les règles de locta voltera
            int déplacement = (int) (Math.random() * (5));
            //int déplacement = 1;
            if (déplacement == 1 && tablo[x - 1][y - 1] == null){
                tablo[x - 1][y - 1] = tablo[x][y];
                tablo[x][y] = null;
                x = x - 1;
                y = y - 1;
            }
            if (déplacement == 2 && tablo[x - 1][y + 1] == null) {
                tablo[x - 1][y + 1] = tablo[x][y];
                tablo[x][y] = null;
                x = x - 1;
                y = y + 1;
            }
            if (déplacement == 3 && tablo[x + 1][y + 1] == null){
                tablo[x + 1][y + 1] = tablo[x][y];
                tablo[x][y] = null;
                x = x + 1;
                y = y + 1;
            }
            if (déplacement == 4 && tablo[x + 1][y - 1] == null){
                tablo[x + 1][y - 1] = tablo[x][y];
                tablo[x][y] = null;
                x = x + 1;
                y = y - 1;
            }
        }
    }

    public void SpawnPot(int nbLap, int nbPot){
        int chance = (int) (Math.random() * (100));
        if (chance > 95 && (nbLap < 2*nbPot || nbLap < 60))
            this.vie = 2;
        if(chance > 98)
            this.vie = 2;
    }

    public void MeurtreMortDetruire(Master[][] tablo){
        if ( tour == 275 )
            tablo[x][y].setMort();
    }

    public void Manger(Master[][]tablo, int nbLapins, int nbPotirons){
        for(int i=-1;i<=1;i++){
            for(int k=-1;k<=1;k++){
                if ((tablo[x+i][y+i] != null && tablo[x+i][y+i].getVie() == 2) && tablo[x][y].getVie()==1){
                    tablo[x+i][y+i] = null;
                    if((int)(Math.random() * (100)) < 5)
                        tablo[x+i][y+i] = new Master(x+i,y+i,0,1);
                }
            }
        }
    }

    public boolean inBounds(){
        boolean inbounds = false;
        if((x > 0 && x < 49) && ( y > 0 && y < 49)) {
            inbounds = true;
            return inbounds;
        }
        return inbounds;
    }
}

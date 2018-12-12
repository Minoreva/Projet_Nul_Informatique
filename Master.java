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
        int chance = (int) (Math.random() * (101));
        if (chance > 90)
            this.vie = 1;
        else if (chance < 10)
            this.vie = 2;
    }

    public int getVie(){
            return this.vie;
    }

    public void déplacer(Master[][] tablo) { // Les points en bordure et/ou entourés ne semblent plus bouger à partir d'un certain moment.
        if (tablo[x][y] != null) { //todo : les règles de locta voltera
            int déplacement = (int) (Math.random() * (5));
            //int déplacement = 1;
            if( x-1 > -1 && y-1 > -1){
				if (déplacement == 1 && tablo[x - 1][y - 1] == null &&  x-1 > -1 && y-1 > -1){
					tablo[x - 1][y - 1] = tablo[x][y];
					tablo[x][y] = null;
					x = x - 1;
					y = y - 1;
				}
            }
            if( x-1 > -1 && y+1 < 50){
				if (déplacement == 2 && tablo[x - 1][y + 1] == null) {
					tablo[x - 1][y + 1] = tablo[x][y];
					tablo[x][y] = null;
					x = x - 1;
					y = y + 1;
				}
			}
            if( x+1 < 50 && y+1 < 50){				
				if (déplacement == 3 && tablo[x + 1][y + 1] == null){
					tablo[x + 1][y + 1] = tablo[x][y];
					tablo[x][y] = null;
					x = x + 1;
					y = y + 1;
				}
			}
            if( x+1 < 50 && y-1 > -1){            
				if (déplacement == 4 && tablo[x + 1][y - 1] == null){
					tablo[x + 1][y - 1] = tablo[x][y];
					tablo[x][y] = null;
					x = x + 1;
					y = y - 1;
				}
			}
        }
    }

    public void MeurtreMortDetruire(Master[][] tablo){
        if ( tour == 275 && this.vie != 3)
            tablo[x][y].setMort();
    }

    public void Manger(Master[][]tablo, int nbLapins, int nbPotirons){
        for(int i=-1;i<=1;i++){
            for(int k=-1;k<=1;k++){
                if ((tablo[x+i][y+i] != null && tablo[x+i][y+i].getVie() == 2) && tablo[x][y].getVie()==1){
                    tablo[x+i][y+i] = null;
                    if((int)(Math.random() * (100)) < 50)
                        tablo[x+i][y+i] = new Master(x+i,y+i,0,1);
                }
            }
        }
    }

    public boolean inBounds(){
        boolean inbounds = false;
        if((x>-1 && y>-1) && (x < 50 && y < 50)){
            inbounds = true;
            return inbounds;
        }
        return inbounds;
    }
    public boolean inBoundsmiam(){
        boolean inbounds = false;
        if((x>0 && x<49)&&(y>0 && y<49)){
            inbounds = true;
            return inbounds;
        }
        return inbounds;
    }
}

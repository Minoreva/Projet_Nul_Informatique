import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Master extends main {
    public int x;
    public int y;
    public double poids;
    public int vie;


    public Master(int x, int y, double poids,int vie) {
        this.x = x;
        this.y = y;
        this.poids = poids;
        this.vie = vie;
    }



    public boolean estVivant(){
        if (this.getVie()!=0)
            return false;
        else
            return true;
    }


    public int getX() {
        return this.x;
    }


    public int getY() {
        return this.y;
    }

    public void setMort(){
        this.vie = 0;

    }

    public void SpawnVie(){
        int chance = (int)(Math.random()*(100));
        if(chance > 95)
            this.vie = 1;
        else if (chance < 5)
            this.vie = 2;
    }

    public int getVie(){
        return this.vie;
    }

    public void setVie(int vie){
        this.vie=vie;
    }

    public void déplacer(Master[][] tablo) {
        for (int i = 0; i < tablo.length; i++) {
            for (int k = 0; k < tablo.length; k++) {
                if(this.getVie() > 0) {
                    int déplacement = (int) (Math.random() * (8));

                    if (déplacement == 1 && ((this.getX() > 0 && this.getY() > 0) && tablo[x-1][y-1].getVie()==0)) {
                        if (this.getVie() == 1 ) {
                            tablo[x - 1][y - 1].setVie(1);
                            tablo[x][y].setVie(0);
                        } else if (this.getVie() == 2) {
                            tablo[x - 1][y - 1].setVie(2);
                            tablo[x][y].setVie(0);
                        }
                    }
                    if (déplacement == 2 && ((this.getX() < 4 && this.getY() > 0)&& tablo[x+1][y-1].getVie()==0)){
                        if (this.getVie() == 1) {
                            tablo[getX() + 1][getY() - 1].setVie(1);
                            tablo[getX()][getY()].setVie(0);
                        } else if (this.getVie() == 2) {
                            tablo[getX() + 1][getY() - 1].setVie(2);
                            tablo[getX()][getY()].setVie(0);
                        }
                    }
                    if (déplacement == 3 && ((this.getX() > 0 && this.getY() < 4 )&& tablo[x-1][y+1].getVie()==0)) {
                        if (this.getVie() == 1) {
                            tablo[x - 1][y + 1].setVie(1);
                            tablo[x][y].setVie(0);
                        } else if (this.getVie() == 2) {
                            tablo[x - 1][y + 1].setVie(2);
                            tablo[x][y].setVie(0);
                        }
                    }
                    if (déplacement == 4 && ((this.getX() < 4 && this.getY() < 4 )&& tablo[x+1][y+1].getVie()==0)) {
                        if (this.getVie() == 1) {
                            tablo[x + 1][y + 1].setVie(1);
                            tablo[x][y].setVie(0);
                        } else if (this.getVie() == 2) {
                            tablo[x + 1][y + 1].setVie(2);
                            tablo[x][y].setVie(0);
                        }
                    }









                }

            }
        }

    }


}

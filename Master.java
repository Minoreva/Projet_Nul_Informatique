import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public abstract class Master extends main{
    public int x;
    public int y;
    public double poids;


    public Master(int x,int y,double poids) {
        this.x = x;
        this.y = y;
        this.poids = poids;
    }

    public void déplacer(){

    }

    public int getX(){
        return this.x;
    }
}

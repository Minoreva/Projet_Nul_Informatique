public class Potiron extends Master {
    int spawn = 0;

    public Potiron(int spawn, int x, int y, double poids){
        super(x,y,poids);
        this.spawn = spawn;




    }

public void Apparaitre(){
    int chance = (int)(Math.random()*(100));
    int xspawn = (int)(Math.random()*(12));
    int yspawn = (int)(Math.random()*(12));

    if(chance > 50){
    //this.setValueAt(1, 1, 1);

    }

}


}

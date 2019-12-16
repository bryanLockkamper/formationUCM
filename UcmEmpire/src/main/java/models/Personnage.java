package models;

import java.time.Period;

public class Personnage extends Entity{
    protected int pa;
    protected int deplacementRestant;
    private int paMax;

    public Personnage(int pv, String name, int pa) {
        super(pv, name);
        this.pa = pa;
        paMax = pa;
    }

    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public int move(int deplacement) {
        int tmp = deplacement - pa;
        pa = Math.max(pa - deplacement, 0);
        return tmp;
    }


    public void deplacementAuto() {

    }

    public void setPaMax() {
        pa = paMax;
    }
}

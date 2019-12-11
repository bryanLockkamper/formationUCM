package models;

import java.time.Period;

public class Personnage extends Entity{
    protected int pa;
    protected int deplacementRestant;

    public Personnage(int pv, String name, int pa) {
        super(pv, name);
        this.pa = pa;
    }

    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public void suicide() {

    }

    public int move(int deplacement) {
        int tmp = deplacement - pa;
        pa = Math.max(pa - deplacement, 0);
        return tmp;
    }


    public void deplacementAuto() {

    }
}

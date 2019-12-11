package models;

public class Personnage extends Entity{
    protected int pa;
    protected int deplacementRestant;
<<<<<<< HEAD
    private int paMax;
=======
>>>>>>> 43ba58ee63c026fac2f39da833f421584149cef0

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

    public void suicide() {

    }

    public int move(int deplacement) {
        int tmp = deplacement - pa;
        pa = Math.max(pa - deplacement, 0);
        return tmp;
    }


    public void deplacementAuto() {

    }
<<<<<<< HEAD

    public void setPaMAx() {
        pa = paMax;
    }
=======
>>>>>>> 43ba58ee63c026fac2f39da833f421584149cef0
}

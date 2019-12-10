package models.unite;

import models.Case;
import models.Personnage;
import models.batiments.Batiment;

public class Constructeur extends Personnage {
    public Constructeur(int pv, String name, int pa) {
        super(pv, name, pa);
    }


    public int construire(Batiment batiment, Case cases) {
        return 0;
    }

    @Override
    public String toString() {
        return "C";
    }
}

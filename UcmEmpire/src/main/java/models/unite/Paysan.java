package models.unite;

import models.Case;
import models.Personnage;
import models.batiments.Batiment;
import models.unite.UnitInterface.IPaysan;

public class Paysan extends Personnage implements IPaysan {

    public Paysan(){

    }

    public Paysan(int pv, String name, int pa) {
        super(pv, name, pa);
    }

    public int recolter(Case cases) {
        return 0;
    }

    @Override
    public String toString() {
        return "P";
    }
}

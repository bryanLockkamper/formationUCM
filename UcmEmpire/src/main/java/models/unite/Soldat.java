package models.unite;

import models.Entity;
import models.Personnage;
import models.unite.UnitInterface.ISoldat;

public class Soldat extends Personnage implements ISoldat {

    public Soldat(){}

    public Soldat(int pv, String name, int pa) {
        super(pv, name, pa);
    }

    public int attaquer(Entity entity){
        return 0;
    }
}

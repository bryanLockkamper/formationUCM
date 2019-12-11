package models.batiments;

import models.Entity;
import models.Ressource;
import models.batiments.BatimentInterfaces.IGrenier;

import java.util.List;

public class Grenier extends Batiment implements IGrenier {

    public Grenier(int pv, String name, Entity prod, List<Ressource> requirement) {
        super(pv, name, prod, requirement);
    }

    @Override
    public int getRessource() {
        return 0;
    }

    @Override
    public void setRessource(int ressource) {

    }
}

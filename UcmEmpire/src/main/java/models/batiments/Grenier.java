package models.batiments;

import models.Entity;
import models.ressources.Ressource;
import models.batiments.BatimentInterfaces.IGrenier;

import java.util.List;

public class Grenier extends Batiment implements IGrenier {

    public Grenier(int pv, String name, List<Ressource> requirement) {
        super(pv, name, requirement);
    }

}

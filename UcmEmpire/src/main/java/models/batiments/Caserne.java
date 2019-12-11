package models.batiments;

import models.Entity;
import models.ressources.Ressource;
import models.batiments.BatimentInterfaces.IBatimentProd;
import models.batiments.BatimentInterfaces.ICaserne;
import models.unite.Soldat;

import java.util.List;

public class Caserne extends BatimentProd implements ICaserne {

    public Caserne(int pv, String name, List<Ressource> requirement) {
        super(pv, name, requirement);
    }

}

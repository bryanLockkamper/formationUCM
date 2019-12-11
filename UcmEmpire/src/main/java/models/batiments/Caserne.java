package models.batiments;

import models.Entity;
import models.ressources.Ressource;
import models.batiments.BatimentInterfaces.IBatimentProd;
import models.batiments.BatimentInterfaces.ICaserne;

import java.util.List;

public class Caserne extends Batiment implements IBatimentProd , ICaserne {

    public Caserne(int pv, String name, Entity prod, List<Ressource> requirement) {
        super(pv, name, prod, requirement);
    }

    @Override
    public List<Entity> getEntities() {
        return null;
    }

    @Override
    public void setEntities(List<Entity> entities) {

    }
}

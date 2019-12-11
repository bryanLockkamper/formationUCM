package models.batiments;

import models.Entity;
import models.batiments.BatimentInterfaces.IForum;
import models.ressources.Ressource;

import java.util.List;

public class Forum extends BatimentProd implements IForum {

    public Forum(int pv, String name, List<Ressource> requirement) {
        super(pv, name, requirement);
    }

    @Override
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    @Override
    public Entity decrementCompteur() {
        return null;
    }


}

package models.batiments;
import models.Entity;
import models.ressources.Ressource;
import models.batiments.BatimentInterfaces.IBatimentProd;
import models.batiments.BatimentInterfaces.IForum;

import java.util.List;

public class Forum extends Batiment implements IBatimentProd , IForum {

    public Forum(int pv, String name, Entity prod, List<Ressource> requirement) {
        super(pv, name, prod, requirement);
    }

    private List<Entity> entities;

    @Override
    public List<Entity> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    

}

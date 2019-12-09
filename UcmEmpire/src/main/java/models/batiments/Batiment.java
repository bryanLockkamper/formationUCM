package models.batiments;

import models.Entity;
import models.Ressource;

import java.util.List;

public class Batiment  extends Entity {
    List<Entity> entities;
    Entity prod;
    List<Ressource> requirement;

    public Batiment(int pv, String name, List<Entity> entities, Entity prod, List<Ressource> requirement) {
        super(pv, name);
        this.entities = entities;
        this.prod = prod;
        this.requirement = requirement;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public Entity getProd() {
        return prod;
    }

    public void setProd(Entity prod) {
        this.prod = prod;
    }

    public List<Ressource> getRequirement() {
        return requirement;
    }

    public void setRequirement(List<Ressource> requirement) {
        this.requirement = requirement;
    }

    public Entity produire(Entity entity) {
        return entity;
    }
}

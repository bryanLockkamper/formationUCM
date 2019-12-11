package models.batiments;

import models.Entity;
import models.Ressource;

import java.util.List;

public abstract class Batiment  extends Entity {
    Entity prod;
    List<Ressource> requirement;

    public Batiment(int pv, String name, Entity prod, List<Ressource> requirement) {
        super(pv, name);
        this.prod = prod;
        this.requirement = requirement;
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

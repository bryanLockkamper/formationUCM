package models.batiments;

import models.Entity;
import models.Ressource;

import java.util.List;

public abstract class Batiment  extends Entity {
    List<Ressource> requirement;

    public Batiment(int pv, String name, List<Ressource> requirement) {
        super(pv, name);
        this.requirement = requirement;
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

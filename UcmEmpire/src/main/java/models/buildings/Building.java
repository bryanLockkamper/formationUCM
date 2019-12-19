package models.buildings;

import models.Entity;
import models.resources.Resource;

import java.util.List;

public abstract class Building extends Entity {
    List<Resource> requirement;

    public Building(int pv, String name, List<Resource> requirement) {
        super(pv, name);
        this.requirement = requirement;
    }

    public List<Resource> getRequirement() {
        return requirement;
    }

    public void setRequirement(List<Resource> requirement) {
        this.requirement = requirement;
    }

    public Entity product(Entity entity) {
        return entity;
    }
}

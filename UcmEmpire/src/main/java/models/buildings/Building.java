package models.buildings;

import models.Entity;
import models.resources.ResourceName;

import java.util.HashMap;

public abstract class Building extends Entity {
    private HashMap<ResourceName, Integer> requirement;

    public Building(int pv, Integer name, HashMap<ResourceName, Integer> requirement) {
        super(pv, name);
        this.requirement = requirement;
    }

    public HashMap<ResourceName, Integer> getRequirement() {
        return requirement;
    }

    public void setRequirement(HashMap<ResourceName, Integer> requirement) {
        this.requirement = requirement;
    }

    public Entity product(Entity entity) {
        return entity;
    }
}

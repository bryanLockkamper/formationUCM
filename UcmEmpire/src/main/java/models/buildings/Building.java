package models.buildings;

import models.Entity;
import models.resources.ResourceName;

import java.util.HashMap;
import java.util.List;

public abstract class Building extends Entity {
    HashMap<ResourceName, Integer> requirement;


    public Building(int pv, String name, HashMap<ResourceName, Integer> requirement) {
        super(pv, name);
        this.requirement = requirement;
    }

    public HashMap<ResourceName, Integer> getRequirement() {
        return requirement;
    }

    public void setRequirement(HashMap<ResourceName, Integer> requirements) {
        this.requirement = requirement;
    }

    public Entity product(Entity entity) {
        return entity;
    }
}

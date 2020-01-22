package models.buildings;

import models.Entity;
import models.resources.Resource;
import models.resources.ResourceName;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Building extends Entity {
    private HashSet<Resource> requirement;

    public Building(int pv, String name, HashSet<Resource> requirement) {
        super(pv, name);
        this.requirement = requirement;
    }

    public HashSet<Resource> getRequirement() {
        return requirement;
    }

    public void setRequirement(HashSet<Resource> requirement) {
        this.requirement = requirement;
    }

    public Entity product(Entity entity) {
        return entity;
    }
}

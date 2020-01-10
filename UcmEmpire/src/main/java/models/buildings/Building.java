package models.buildings;

import models.Entity;
import models.ressources.RessourceName;

import java.util.HashMap;

public abstract class Building extends Entity {
    HashMap<RessourceName, Integer> requirement;

    public Building(int pv, String name, HashMap<RessourceName, Integer> requirement) {
        super(pv, name);
        this.requirement = requirement;
    }

    public HashMap<RessourceName, Integer> getRequirement() {
        return requirement;
    }

    public void setRequirement(HashMap<RessourceName, Integer> requirement) {
        this.requirement = requirement;
    }

    public Entity product(Entity entity) {
        return entity;
    }
}

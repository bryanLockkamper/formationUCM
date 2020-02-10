package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Building extends Entity {
    private HashSet<Resource> requirement;

    public Building(int pv, Integer id, HashSet<Resource> requirement) {
        super(pv, id);
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

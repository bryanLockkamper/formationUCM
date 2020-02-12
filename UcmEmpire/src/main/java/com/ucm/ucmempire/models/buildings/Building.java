package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.resources.Resource;

import java.util.HashSet;

public abstract class Building extends Entity {
    private Integer idUser;
    private HashSet<Resource> requirement;

    public Building(int pv, Integer idUser, HashSet<Resource> requirement) {
        super(pv);
        this.requirement = requirement;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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

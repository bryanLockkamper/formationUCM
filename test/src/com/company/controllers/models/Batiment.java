package com.company.controllers.models;

import com.company.models.Entity;
import com.company.models.Ressource;

import java.util.List;

public class Batiment  extends com.company.models.Entity {
    List<com.company.models.Entity> entities;
    com.company.models.Entity prod;
    List<Ressource> requirement;

    public Batiment(int pv, String name, List<com.company.models.Entity> entities, com.company.models.Entity prod, List<Ressource> requirement) {
        super(pv, name);
        this.entities = entities;
        this.prod = prod;
        this.requirement = requirement;
    }

    public List<com.company.models.Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<com.company.models.Entity> entities) {
        this.entities = entities;
    }

    public com.company.models.Entity getProd() {
        return prod;
    }

    public void setProd(com.company.models.Entity prod) {
        this.prod = prod;
    }

    public List<Ressource> getRequirement() {
        return requirement;
    }

    public void setRequirement(List<Ressource> requirement) {
        this.requirement = requirement;
    }

    public com.company.models.Entity produire(Entity entity) {
        return entity;
    }
}

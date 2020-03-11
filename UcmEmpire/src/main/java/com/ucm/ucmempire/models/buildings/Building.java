package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.dto.EntityDTO;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import lombok.EqualsAndHashCode;

import java.util.HashSet;

@EqualsAndHashCode (callSuper = true)

public abstract class Building extends Entity {
    private Integer idUser;
    private HashSet<Resource> requirement;

    public Building(int pv, Integer idUser, HashSet<Resource> requirement) {
        super(pv);
        this.idUser = idUser;
        this.requirement = requirement;
    }

    public Building(EntityDTO entityDTO)
    {
        super (entityDTO.getHp());
        this.idUser = entityDTO.getIdPlayer();
    }

    public Building() {

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

    public Resource getRequirement(ResourceName resourceName){
        return requirement.stream()
                .filter(resource -> resource.getResourceName().equals(resourceName))
                .findFirst().orElse(null);
    }

    public void setRequirement(HashSet<Resource> requirement) {
        this.requirement = requirement;
    }
}

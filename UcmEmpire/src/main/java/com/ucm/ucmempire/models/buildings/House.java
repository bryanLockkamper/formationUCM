package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.dto.EntityDTO;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IHouse;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.HashSet;
@EqualsAndHashCode(callSuper = true)

public class House extends Building implements IHouse {
    public House(int hp, Integer idUser, HashSet<Resource> requirement) {
        super(hp, idUser, requirement);
    }
    public House (EntityDTO entityDTO) {super (entityDTO.getHp(),entityDTO.getIdPlayer(),null);} //TODO DAMIEN : RESSOURCE

    @Override
    public String toString() {
        return "House{" +
                "hp=" + hp +
                "} " + super.toString();
    }
}


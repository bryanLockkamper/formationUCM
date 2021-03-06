package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.dto.EntityDTO;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IGranary;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.HashSet;
@EqualsAndHashCode(callSuper = true)

public class Granary extends Building implements IGranary {

    public Granary(int hp, Integer idUser , HashSet<Resource> requirement) {
        super(hp, idUser, requirement);
    }

    public Granary (EntityDTO entityDTO) {super (entityDTO.getHp(),entityDTO.getIdPlayer(),null);} //TODO DAMIEN : RESSOURCE

    @Override
    public String toString() {
        return "Granary{" +
                "hp=" + hp +
                "} " + super.toString();
    }
}

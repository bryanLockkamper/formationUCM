package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IBarracks;
import com.ucm.ucmempire.models.dto.EntityDTO;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import io.cucumber.java.hu.Ha;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@EqualsAndHashCode (callSuper = true)
public class Barracks extends ProdBuilding implements IBarracks {

    public Barracks(int hp, Integer idUser, HashSet<Resource> requirement) {
        super(hp, idUser, requirement);
    }

    public Barracks(EntityDTO entityDTO) {super (entityDTO.getHp(),entityDTO.getIdPlayer(),null);} //TODO DAMIEN : RESSOURCE

    public Barracks(int idPlayer) {
        super(50,idPlayer,null);
        HashSet<Resource> hashSet = new HashSet<>();
        hashSet.add(new Resource(ResourceName.FOOD, 30));
        hashSet.add(new Resource(ResourceName.WOOD, 50));
        hashSet.add(new Resource(ResourceName.STONE, 50));
        setRequirement(hashSet);
    }

    @Override
    public void setEntities(List<Entity> entities) {

    }

    @Override
    public String toString() {
        return "Barracks{" +
                "hp=" + hp +
                "} " + super.toString();
    }
}

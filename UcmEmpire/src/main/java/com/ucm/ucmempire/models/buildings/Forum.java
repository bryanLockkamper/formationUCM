package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IForum;
import com.ucm.ucmempire.models.dto.EntityDTO;
import com.ucm.ucmempire.models.resources.Resource;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@EqualsAndHashCode (callSuper = true)

public class Forum extends ProdBuilding implements IForum {

    private List<Entity> entities;

    public Forum(int idPlayer) {
        super(50,idPlayer,null);
        entities = new ArrayList<>();
    }

    public Forum(int hp, Integer idUser, HashSet<Resource> requirement) {
        super(hp, idUser, requirement);
    }

    public Forum (EntityDTO entityDTO) {super (entityDTO.getHp(),entityDTO.getIdPlayer(),null);} //TODO DAMIEN : RESSOURCE

    public List<Entity> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    @Override
    public Integer decrementCounter() {
        return 0;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "entities=" + entities +
                ", hp=" + hp +
                "} " + super.toString();
    }
}

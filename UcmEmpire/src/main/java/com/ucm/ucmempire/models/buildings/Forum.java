package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IForum;
import com.ucm.ucmempire.models.dto.EntityDTO;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@EqualsAndHashCode (callSuper = true)

public class Forum extends ProdBuilding implements IForum {

    public Forum(int idPlayer) {
        super(50,idPlayer, null);
    }

    public Forum(int hp, Integer idUser, HashSet<Resource> requirement) {
        super(hp, idUser, requirement);
    }

    public Forum (EntityDTO entityDTO) {super (entityDTO.getHp(),entityDTO.getIdPlayer(),null);} //TODO DAMIEN : RESSOURCE

    @Override
    public String toString() {
        return "Forum{" +
                ", hp=" + hp +
                "} " + super.toString();
    }
}

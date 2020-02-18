package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IBarracks;
import com.ucm.ucmempire.models.resources.Resource;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.List;
@EqualsAndHashCode (callSuper = true)
public class Barracks extends ProdBuilding implements IBarracks {

    public Barracks(int hp, Integer idUser, HashSet<Resource> requirement) {
        super(hp, idUser, requirement);
    }

    @Override
    public void setEntities(List<Entity> entities) {

    }

    @Override
    public Entity decrementCounter() {
        return null;
    }
}

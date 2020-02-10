package com.ucm.ucmempire.models.buildings.buildingInterfaces;

import com.ucm.ucmempire.models.Entity;

import java.util.List;

public interface IProdBuilding {

    List<Entity> getEntities();
    Entity decrementCounter();

    void setEntities(List<Entity> entities);
}

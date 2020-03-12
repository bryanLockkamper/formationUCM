package com.ucm.ucmempire.models.buildings.buildingInterfaces;

import com.ucm.ucmempire.models.Entity;

import java.util.List;

public interface IProdBuilding {

    Integer decrementCounter();

    void setEntities(List<Entity> entities);
}

package models.buildings.buildingInterfaces;

import models.Entity;

import java.util.List;

public interface IProdBuilding {

    List<Entity> getEntities();
    Entity decrementCounter();

    void setEntities(List<Entity> entities);
}

package models.buildings;

import models.resources.Resource;
import models.buildings.buildingInterfaces.IHouse;

import java.util.List;

public class House extends Building implements IHouse {
    public House(int hp, String name, List<Resource> requirement) {
        super(hp, name, requirement);
    }
}

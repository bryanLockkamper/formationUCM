package models.buildings;

import models.buildings.buildingInterfaces.IHouse;
import models.resources.ResourceName;

import java.util.HashMap;
import java.util.List;

public class House extends Building implements IHouse {
    public House(int hp, String name, HashMap<ResourceName, Integer> requirement) {
        super(hp, name, requirement);
    }
}

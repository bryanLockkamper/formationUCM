package models.buildings;

import models.resources.ResourceName;
import models.buildings.buildingInterfaces.IHouse;

import java.util.HashMap;

public class House extends Building implements IHouse {
    public House(int hp, String name, HashMap<ResourceName, Integer> requirement) {
        super(hp, name, requirement);
    }
}

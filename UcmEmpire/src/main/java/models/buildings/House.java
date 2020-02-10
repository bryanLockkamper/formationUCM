package models.buildings;

import models.resources.Resource;
import models.resources.ResourceName;
import models.buildings.buildingInterfaces.IHouse;

import java.util.HashMap;
import java.util.HashSet;

public class House extends Building implements IHouse {
    public House(int hp, Integer id, HashSet<Resource> requirement) {
        super(hp, id, requirement);
    }
}

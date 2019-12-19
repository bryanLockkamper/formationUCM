package models.buildings;

import models.buildings.buildingInterfaces.IGranary;
import models.resources.ResourceName;

import java.util.HashMap;
import java.util.List;

public class Granary extends Building implements IGranary {

    public Granary(int hp, String name, HashMap<ResourceName, Integer> requirement) {
        super(hp, name, requirement);
    }

}

package models.buildings;

import models.resources.ResourceName;
import models.buildings.buildingInterfaces.IGranary;

import java.util.HashMap;

public class Granary extends Building implements IGranary {

    public Granary(int hp, Integer name, HashMap<ResourceName, Integer> requirement) {
        super(hp, name, requirement);
    }

}

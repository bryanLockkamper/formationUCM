package models.buildings;

import models.resources.Resource;
import models.resources.ResourceName;
import models.buildings.buildingInterfaces.IGranary;

import java.util.HashMap;
import java.util.HashSet;

public class Granary extends Building implements IGranary {

    public Granary(int hp, Integer id , HashSet<Resource> requirement) {
        super(hp, id, requirement);
    }

}
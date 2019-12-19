package models.buildings;

import models.resources.Resource;
import models.buildings.buildingInterfaces.IGranary;

import java.util.List;

public class Granary extends Building implements IGranary {

    public Granary(int hp, String name, List<Resource> requirement) {
        super(hp, name, requirement);
    }

}

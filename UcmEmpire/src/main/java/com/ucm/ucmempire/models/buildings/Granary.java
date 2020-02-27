package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IGranary;

import java.util.HashMap;
import java.util.HashSet;

public class Granary extends Building implements IGranary {

    public Granary(int hp, Integer id , HashSet<Resource> requirement) {
        super(hp, id, requirement);
    }

}

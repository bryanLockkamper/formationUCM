package com.ucm.ucmempire.models.buildings;

import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.buildings.buildingInterfaces.IHouse;

import java.util.HashMap;
import java.util.HashSet;

public class House extends Building implements IHouse {
    public House(int hp, Integer id, HashSet<Resource> requirement) {
        super(hp, id, requirement);
    }
}

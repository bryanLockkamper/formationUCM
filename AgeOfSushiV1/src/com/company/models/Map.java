package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class Map {
    protected List<List<Case>> map;
    protected String name;

    public Map(List<List<Case>> map, String name) {
        this.map = map;
        this.name = name;
    }

    public Map(String name) {
        this.name = name;
        map = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            map.add(new ArrayList<>());
            for (int j = 0; j < 10; j++) {
                map.get(i).add(new Case("P", new Biome("plaine")));
            }
        }
    }

    public List<List<Case>> getMap() {
        return map;
    }

    public void setMap(List<List<Case>> map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.company.controllers.models;

import com.company.models.Biome;
import com.company.models.Case;
import com.company.models.Paysan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
                map.get(i).add(new Case((new Random().nextInt(5) == 0) ? new Paysan(100, "payon", 5) : " ", new Biome("plaine")));
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

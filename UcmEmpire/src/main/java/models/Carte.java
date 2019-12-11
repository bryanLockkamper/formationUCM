package models;

import models.unite.Paysan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carte {
    protected List<List<Case>> map;
    protected String name;

    public Carte(List<List<Case>> map, String name) {
        this.map = map;
        this.name = name;
    }

    public Carte(String name) {
        this.name = name;
        map = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            map.add(new ArrayList<>());
            for (int j = 0; j < 10; j++) {
                map.get(i).add(new Case((new Random().nextInt(5) == 0) ? new Paysan(100, "payon", 5) : " ", new Biome("plaine")));
            }
        }
    }

    public List<List<Case>> getCarte() {
        return map;
    }

    public void setCarte(List<List<Case>> map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

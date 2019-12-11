package models.biomes;

import Case;

import java.util.ArrayList;

public class Biome {

    private ArrayList<Case> biomes;
    private String name;
    private Boolean isWalkable;
    private int dimension;

    public Biome(String name, Boolean isWalkable, int dimension) {
        this.name = name;
        this.isWalkable = isWalkable;
        this.dimension = dimension;
    }

    public ArrayList<Case> getBiomes() {
        return biomes;
    }

    public void setBiomes(ArrayList<Case> biomes) {
        this.biomes = biomes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getWalkable() {
        return isWalkable;
    }

    public void setWalkable(Boolean walkable) {
        isWalkable = walkable;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}

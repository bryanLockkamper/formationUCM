package models.boardPackage;

import models.biomes.Biome;

public class Square<T> {
    private T content;
    private boolean isWalkable;
    private boolean isBuildable;
    private Biome biome;

    public Square(T content) {
        this.content = content;
    }

    public Square(T content, boolean isBuildable, boolean isWalkable) {
        this(content);
        this.isBuildable = isBuildable;
        this.isWalkable = isWalkable;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean isWalkable() {
        return isWalkable;
    }

    public void setWalkable(boolean walkable) {
        isWalkable = walkable;
    }

    public boolean isBuildable() {
        return isBuildable;
    }

    public void setBuildable(boolean buildable) {
        isBuildable = buildable;
    }

    public Biome getBiome() {
        return biome;
    }

    public void setBiome(Biome biome) {
        this.biome = biome;
    }
}

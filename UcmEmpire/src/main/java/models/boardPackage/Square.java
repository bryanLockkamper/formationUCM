package models.boardPackage;

import models.biomes.Biome;
import models.biomes.BiomeType;

public class Square<T> {
    private T content;
    private boolean isWalkable;
    private boolean isBuildable;
    private BiomeType biome;

    public Square(T content) {
        this.content = content;
    }

    public Square(T content, boolean isBuildable, boolean isWalkable, BiomeType biome) {
        this(content);
        this.isBuildable = isBuildable;
        this.isWalkable = isWalkable;
        this.biome = biome;
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

    public BiomeType getBiome() {
        return biome;
    }
}

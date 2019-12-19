package models.BoardPackage;

import models.biomes.BiomeType;

public class Case<T> {
    private T content;
    private boolean isWalk;
    private boolean isBuild;
    private BiomeType biome;

    public Case(T content, boolean isBuild, boolean isWalk,BiomeType biome) {
        this.content = content;
        this.isBuild = isBuild;
        this.isWalk = isWalk;
        this.biome = biome;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean isWalk() {
        return isWalk;
    }


    public boolean isBuild() {
        return isBuild;
    }

    public void setBuild(boolean build) {
        isBuild = build;
    }

    public BiomeType getBiome() {
        return biome;
    }
}

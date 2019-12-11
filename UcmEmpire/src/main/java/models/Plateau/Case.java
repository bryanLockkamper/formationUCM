package models.Plateau;

import models.biomes.Biome;

public class Case<T> {
    private T content;
    private boolean isWalk;
    private boolean isBuild;
    private Biome biome;

    public Case(T content) {
        this.content = content;
    }

    public Case(T content, boolean isBuild, boolean isWalk) {
        this(content);
        this.isBuild = isBuild;
        this.isWalk = isWalk;
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

    public void setWalk(boolean walk) {
        isWalk = walk;
    }

    public boolean isBuild() {
        return isBuild;
    }

    public void setBuild(boolean build) {
        isBuild = build;
    }

    public Biome getBiome() {
        return biome;
    }

    public void setBiome(Biome biome) {
        this.biome = biome;
    }
}

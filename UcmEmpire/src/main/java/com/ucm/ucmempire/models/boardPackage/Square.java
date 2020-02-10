package com.ucm.ucmempire.models.boardPackage;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.biomes.BiomeType;

public class Square {
    private Entity content;
    private boolean isWalkable;
    private boolean isBuildable;
    private BiomeType biome;

    public Square(Entity content) {
        this.content = content;
    }

    public Square(Entity content, boolean isBuildable, boolean isWalkable, BiomeType biome) {
        this(content);
        this.isBuildable = isBuildable;
        this.isWalkable = isWalkable;
        this.biome = biome;
    }

    public Entity getContent() {
        return content;
    }

    public void setContent(Entity content) {
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

    @Override
    public String toString() {
        return content.toString() ;
    }
}

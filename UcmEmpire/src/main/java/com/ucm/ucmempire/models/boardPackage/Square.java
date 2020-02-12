package com.ucm.ucmempire.models.boardPackage;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.biomes.BiomeType;
import java.util.List;

public class Square {

    private Integer id;

    private boolean isWalkable;
    private boolean isBuildable;
    private boolean isSpecial;
    private BiomeType biome;

    private Entity contents;

    public Square(Entity contents) {
        this.contents = contents;
    }

    public Square(Entity contents, boolean isBuildable, boolean isWalkable, BiomeType biome) {
        this(contents);
        this.isBuildable = isBuildable;
        this.isWalkable = isWalkable;
        this.biome = biome;
    }

    public Entity getContent() {
        return contents;
    }

    public void setContent(Entity contents) {
        this.contents = contents;
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

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public BiomeType getBiome() {
        return biome;
    }

    @Override
    public String toString() {
        return contents.toString() ;
    }
}

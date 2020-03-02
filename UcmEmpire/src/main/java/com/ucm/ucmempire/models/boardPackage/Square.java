package com.ucm.ucmempire.models.boardPackage;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.biomes.BiomeType;
import com.ucm.ucmempire.models.dto.SquareDTO;
import lombok.EqualsAndHashCode;

import java.util.List;
@EqualsAndHashCode
public class Square {

    private boolean isWalkable;
    private boolean isBuildable;
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

    public Square (SquareDTO squareDTO)
    {
        this.isBuildable = squareDTO.isBuildable();
        this.isWalkable = squareDTO.isWalkable();
        this.biome = BiomeType.valueOf(squareDTO.getBiomeType());
        this.contents = new Entity(squareDTO.getEntityDTOList().get(0));
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

    public BiomeType getBiome() {
        return biome;
    }

    @Override
    public String toString() {
        return "Square{" +
                "isWalkable=" + isWalkable +
                ", isBuildable=" + isBuildable +
                ", biome=" + biome +
                ", contents=" + contents +
                '}';
    }
}

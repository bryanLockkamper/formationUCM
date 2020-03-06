package com.ucm.ucmempire.models.dto;

import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.boardPackage.Square;

import java.util.List;
import java.util.stream.Collectors;


public class SquareDTO {

    private boolean isWalkable;
    private boolean isBuildable;
    private String biomeType;
    private boolean isSpecial;
    private List<EntityDTO> entityDTOList;

    public SquareDTO() {
    }

    public SquareDTO (Square square)
    {
        this.isWalkable = square.isWalkable();
        this.isBuildable = square.isBuildable();
        this.biomeType = square.getBiome().getType();
        this.isSpecial = square instanceof SpecialSquare;
        if (square instanceof SpecialSquare)
        {
            this.entityDTOList = ((SpecialSquare) square).getFarmers().stream()
                    .map(EntityDTO::new)
                    .collect(Collectors.toList());
        }
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

    public String getBiomeType() {
        return biomeType;
    }

    public void setBiomeType(String biomeType) {
        this.biomeType = biomeType;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public List<EntityDTO> getEntityDTOList() {
        return entityDTOList;
    }

    public void setEntityDTOList(List<EntityDTO> entityDTOList) {
        this.entityDTOList = entityDTOList;
    }

    @Override
    public String toString() {
        return "SquareDTO{" +
                "isWalkable=" + isWalkable +
                ", isBuildable=" + isBuildable +
                ", biomeType='" + biomeType + '\'' +
                ", isSpecial=" + isSpecial +
                ", entityDTOList=" + entityDTOList +
                '}';
    }
}

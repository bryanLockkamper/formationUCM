package com.ucm.ucmempire.models.dto;

import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.boardPackage.Square;

import java.util.List;
import java.util.stream.Collectors;


public class SquareDTO {
    private String biomeType;
    private boolean isSpecial;
    private EntityDTO content;
    private List<EntityDTO> entityDTOList;

    public SquareDTO() {
    }

    public SquareDTO (Square square)
    {
        this.biomeType = square.getBiome().getType();
        this.isSpecial = square instanceof SpecialSquare;
        this.content = square.getContent() != null? new EntityDTO(square.getContent()) : null;
        if (square instanceof SpecialSquare && ((SpecialSquare) square).getFarmers() != null)
        {
            this.entityDTOList = ((SpecialSquare) square).getFarmers().stream()
                    .map(EntityDTO::new)
                    .collect(Collectors.toList());
        }
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

    public EntityDTO getContent() {
        return content;
    }

    public void setContent(EntityDTO content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SquareDTO{" +
                ", biomeType='" + biomeType + '\'' +
                ", isSpecial=" + isSpecial +
                ", entityDTOList=" + entityDTOList +
                '}';
    }
}

package com.ucm.ucmempire.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class SquareDTO {

    private boolean isWalkable;
    private boolean isBuilding;
    private String biomeType;
    private boolean isSpecial;
    private List<EntityDTO> entityDTOList;
}

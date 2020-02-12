package com.ucm.ucmempire.models.dto;

import com.ucm.ucmempire.models.dto.Entities.EntityDTO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SquareDTO {

    private Boolean isWalkable;
    private Boolean isBuildable;
    private String biome;
    private EntityDTO entityDTO;
}

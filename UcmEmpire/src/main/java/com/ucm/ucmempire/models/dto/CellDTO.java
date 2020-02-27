package com.ucm.ucmempire.models.dto;

import com.ucm.ucmempire.controllers.pathfinding.Position;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CellDTO {
    private int rowId;
    private int id;

    public CellDTO() {
    }

    public CellDTO(Position position) {
        rowId = position.getX();
        id = position.getY();
    }
}

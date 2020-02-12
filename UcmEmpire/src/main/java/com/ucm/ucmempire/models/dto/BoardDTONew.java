package com.ucm.ucmempire.models.dto;
import com.ucm.ucmempire.models.boardPackage.Square;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class BoardDTONew {

    private String name;
    private ArrayList<ArrayList<SquareDTO>> board;
}

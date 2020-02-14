package com.ucm.ucmempire.models.dto;

import com.ucm.ucmempire.models.boardPackage.Square;
import lombok.Data;

import java.util.List;

@Data
public class BoardDTO {


    private String name;
    private List<SquareDTO> squareDTOList;

}

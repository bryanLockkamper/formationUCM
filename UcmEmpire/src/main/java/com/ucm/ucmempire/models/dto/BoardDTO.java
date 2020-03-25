package com.ucm.ucmempire.models.dto;

import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.boardPackage.Board;
import com.ucm.ucmempire.models.boardPackage.Square;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class BoardDTO {

    private String name;
    private ArrayList<ArrayList<SquareDTO>> squareDTOList;

    public BoardDTO() {
    }

    public BoardDTO (Board board)
    {
        this.name = board.getName();

        ArrayList<ArrayList<SquareDTO>> boardSquareDTOList = new ArrayList<>(board.getBoard().size());

        // init the column
        for (int i = 0; i < board.getBoard().size(); i++) { boardSquareDTOList.add(new ArrayList<>()); }

        for (int i = 0; i< board.getBoard().size();i++)
        {
            for (int j = 0; j < board.getBoard().get(i).size();j++)
            {
                boardSquareDTOList.get(i).add(new SquareDTO(board.getBoard().get(i).get(j)));
            }
        }
        this.squareDTOList = boardSquareDTOList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ArrayList<SquareDTO>> getSquareDTOList() {
        return squareDTOList;
    }

    public void setSquareDTOList(ArrayList<ArrayList<SquareDTO>> squareDTOList) {
        this.squareDTOList = squareDTOList;
    }
}

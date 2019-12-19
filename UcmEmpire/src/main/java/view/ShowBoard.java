package view;

import models.boardPackage.Board;
import models.boardPackage.SpecialSquare;

public class ShowBoard {

    public void showBoardV1() {
        //TODO : generation des cases
        Board board = new Board("technobel");
        for (int i = 0; i < board.getBoard().size(); i++) {

            for (int j = 0; j < board.getBoard().get(i).size(); j++) {
                System.out.print("| ");
                if (board.getBoard().get(i).get(j) instanceof SpecialSquare) {
                    System.out.print("S ");

                } else {
                    System.out.print("  ");
                }

            }
            System.out.println("|");

        }

    }


}

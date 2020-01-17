package view;

import models.boardPackage.Board;
import models.boardPackage.SpecialSquare;

public class ShowBoard {

    public void showBoardV1() {
        //TODO : generation des cases
        Board board = new Board("technobel");
        showBoardV1(board);
    }


    public static void showBoardV1(Board board) {
        //TODO : generation des cases
        for (int i = 0; i < board.getBoard().size(); i++) {

            for (int j = 0; j < board.getBoard().get(i).size(); j++) {
                System.out.print("| ");
                if (board.getBoard().get(i).get(j) instanceof SpecialSquare) {
                    System.out.print("S ");
                } else if(board.getBoard().get(i).get(j).getContent() != null && board.getBoard().get(i).get(j).getContent().getName().equals("payon")) {
                    System.out.print("P ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println("|");

        }

    }


}

package View;

import models.BoardPackage.Board;
import models.BoardPackage.CaseSpecial;

public class ShowBoard {

    public void showBoardV1() {
        //TODO : generation des cases
        Board board = new Board("technobel");
        for (int i = 0; i < board.getBoard().size(); i++) {

            for (int j = 0; j < board.getBoard().get(i).size(); j++) {
                System.out.print("| ");
                if (board.getBoard().get(i).get(j) instanceof CaseSpecial) {
                    System.out.print("S ");

                } else {
                    System.out.print("  ");
                }

            }
            System.out.println("|");

        }

    }


}

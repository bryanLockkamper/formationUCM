package View;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import models.Plateau.CaseSpecial;
import models.Plateau.Plateau;

public class ShowBoard {

    public void showBoardV1() {
        //TODO : generation des cases
        Plateau plateau = new Plateau("technobel");
        for (int i = 0; i < plateau.getBoard().size(); i++) {

            for (int j = 0; j < plateau.getBoard().get(i).size(); j++) {

                if (plateau.getBoard().get(i).get(j) instanceof CaseSpecial) {
                    System.out.print(" S |   ");

                } else {
                    System.out.print("   |   ");
                }

            }
            System.out.println();

        }

    }


}

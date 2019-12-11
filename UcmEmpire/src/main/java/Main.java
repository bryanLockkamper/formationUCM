

import Case;
import models.Plateau.Plateau;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Plateau plateau = new Plateau("Test");

        System.out.println("|---------------------|");
        for (List<Case> cases : plateau.getMap()) {
            System.out.print("| ");
            for (Case cas : cases) {
                System.out.print(cas.getContent() + " ");
            }
            System.out.println("|");
        }
        System.out.println("|---------------------|");
    }
}

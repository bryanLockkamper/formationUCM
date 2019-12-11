

import models.Case;
import models.Plateau;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Plateau carte = new Plateau("Test");

        System.out.println("|---------------------|");
        for (List<Case> cases : carte.getCarte()) {
            System.out.print("| ");
            for (Case cas : cases) {
                System.out.print(cas.getContent() + " ");
            }
            System.out.println("|");
        }
        System.out.println("|---------------------|");
    }
}

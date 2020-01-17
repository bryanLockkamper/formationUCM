import controllers.pathfinding.Position;
import models.Entity;
import models.boardPackage.Board;
import models.boardPackage.Square;
import models.units.Soldier;
import view.LayoutWindow;
import view.ShowBoard;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Board board = new Board("test");
        board.setSquare(new Position(0,0), new Entity(20, "payon"));
        ShowBoard.showBoardV1(board);
//        LayoutWindow ucmEmpire = new LayoutWindow();
/*
        ShowBoard showBoard = new ShowBoard();
        showBoard.showBoardV1();
        //Jeu jeu = new Jeu();
        Map map = new Map("Test");

        System.out.println("|---------------------|");
        for (List<Case> cases : plateau.getPlateau()) {
            System.out.print("| ");
            for (Case cas : cases) {
                System.out.print(cas.getContent() + " ");
            }
            System.out.println("|");
        }
        System.out.println("|---------------------|");

        Forum forum = new Forum(50,"Forum",null);
        Caserne caserne = new Caserne(25,"Caserne",null);

        Soldat soldat = (Soldat) caserne.getUnit(3);
        Paysan paysan = (Paysan) forum.getUnit(1);
        Constructeur constructeur = (Constructeur) forum.getUnit(2);

        System.out.println("Paysan " + paysan.getName());
        System.out.println("Constructeur " + constructeur.getName());
        System.out.println("Soldat " + soldat.getName() + " " + soldat.getPv() +" PV ");

        paysan.recolter();
        soldat.attaquer(paysan);
        constructeur.construire(null,null);

        System.out.println();
        System.out.println("|---------------------|");*/
    }
}

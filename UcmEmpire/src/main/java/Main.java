

import controllers.pathfinding.AStarService;
import controllers.pathfinding.Position;
import models.Entity;
import models.biomes.BiomeFactory;
import models.biomes.BiomeType;
import models.biomes.IBiomes;
import models.boardPackage.Board;
import models.boardPackage.SpecialSquare;
import view.ShowBoard;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Board board = new Board("test");
        board.setSquare(new Position(0,0), new Entity(45, "payon"));
        AStarService aStarService = new AStarService(board, new Position(0,0), new Position(5,5));

        for (int i = 0; i < board.getBoard().size(); i++) {

            for (int j = 0; j < board.getBoard().get(i).size(); j++) {
                System.out.print("| ");
                if (board.getBoard().get(i).get(j) instanceof SpecialSquare) {
                    System.out.print("S ");
                } else if (board.getBoard().get(i).get(j).getContent() != null && board.getBoard().get(i).get(j).getContent().getName().equals("payon")) {
                    System.out.print("P ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println("|");

        }

        board.setSquare(new Position(0,0), null);

        board.setSquare(aStarService.run(1), new Entity(45, "payon"));

        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < board.getBoard().size(); i++) {

            for (int j = 0; j < board.getBoard().get(i).size(); j++) {
                System.out.print("| ");
                if (board.getBoard().get(i).get(j) instanceof SpecialSquare) {
                    System.out.print("S ");
                } else if (board.getBoard().get(i).get(j).getContent() != null && board.getBoard().get(i).get(j).getContent().getName().equals("payon")) {
                    System.out.print("P ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println("|");

        }

        //ShowBoard showBoard = new ShowBoard();
        //showBoard.showBoardV1();

        //Jeu jeu = new Jeu();
        /*Map map = new Map("Test");

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

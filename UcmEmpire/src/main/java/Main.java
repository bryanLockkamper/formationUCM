import controllers.Game;
import controllers.pathfinding.Position;
import models.Entity;
import models.Player;
import models.boardPackage.Board;
import view.LayoutWindow;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        /*Board board = new Board("test");
        board.setSquare(new Position(0, 0), new Entity(20, "payon"));
        Player p1 = new Player();
        p1.setName("test");
        Player p2 = new Player();
        Game game = Game.getGame(p1, p2, board);
        Thread thread = new Thread(game);

        thread.start();
        Thread.sleep(1000);
        // TODO: 21-01-20 notifier que le joueur termine son tour manuellement
        synchronized (game) {
            game.notify();
        }*/

        LayoutWindow ucmEmpire = new LayoutWindow();
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



import controllers.Jeu;
import models.Case;
import models.Plateau;
import models.batiments.Caserne;
import models.batiments.Forum;
import models.unite.Constructeur;
import models.unite.Paysan;
import models.unite.Soldat;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Plateau plateau = new Plateau("Test");
        Jeu jeu = new Jeu();
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

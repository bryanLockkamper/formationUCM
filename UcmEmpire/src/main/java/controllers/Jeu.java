package controllers;

import models.*;
import models.Plateau.Board;
import models.Plateau.Case;
import models.unite.Soldat;

import java.util.Timer;
import java.util.TimerTask;

public class Jeu {
    private boolean finTour;
    public Jeu() {
        Joueur joueur = new Joueur();
        Joueur ia = new Joueur();
        Board map = new Board();
        boolean victoire = false,
                perdu = false;
        Timer timer = new Timer();
        while (!victoire | !perdu) {
            //AVANT TOUR
            joueur.construireEntite();
            joueur.recolteRessourcesAuto();
            //TOUR
            finTour = false;

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    finTour = true;
                }
            }, 500);

            Case<Entity> first = new Case<>(joueur.getEntity(0));
            String action = "deplacer";
            Case<Entity> second = new Case<>(null);

            while (!finTour) {
                if (first.getContent() instanceof Entity) {
                    boolean exist = false;
                    for (int i = 0; i < joueur.getEntities().size() & !exist; i++)
                        if (joueur.getEntities().get(i).equals(first.getContent()))
                            exist = true;
                        if (exist)  {
                            switch (action) {
                                case "deplacer":
                                    if (first.getContent() instanceof Personnage) {
                                        ((Personnage) first.getContent()).move(1);
                                        map.move(first, second);
                                    }
                                    // TODO: 11-12-19 event deplacement
                                    break;
                                case "suicide":
                                     if (first.getContent() instanceof Entity)
                                     first.getContent().suicide();
                                     break;
                                case "attaque":
                                    if (first.getContent() instanceof Soldat) {
                                        boolean mort = second.getContent().takeDamage(((Soldat)first.getContent()).attaquer());
                                        if (mort) {
                                         ia.getEntities().remove(second.getContent());
                                         map.remove(second);
                                        }
                                    }
                                    // TODO: 11-12-19 event attaquer
                                     break;
                                case "creer":
                                     map.setCase(second);
                                     joueur.addEntity(second.getContent());
                                     break;
                            }
                        }
                }
            }
            timer.purge();

            //APRES TOUR
            joueur.deplacementUniteAuto();
            joueur.maxPa();
            perdu = joueur.aPerdu();
            victoire = ia.aPerdu();
        }
        timer.cancel();
    }
}

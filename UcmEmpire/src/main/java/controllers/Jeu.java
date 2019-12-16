package controllers;

import models.*;
import models.unite.Soldat;

import java.util.Timer;
import java.util.TimerTask;

public class Jeu {
    private boolean finTour;
    public Jeu() {
        Joueur joueur = new Joueur();
        Joueur ia = new Joueur();
        Plateau map = new Plateau();
        boolean victoire = false;
        boolean perdu = false;
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
                    // TODO: 11-12-19 verifier entité appartient au joueur
                    // TODO: 11-12-19 event selection entité
                    // TODO: 11-12-19 switch sur les actions
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

                            }
                            // TODO: 11-12-19 event attaquer
                            break;
                        case "creer":
                            break;
                    }
                } else {
                    //Case ressources
                    // TODO: 11-12-19 event selection ressources
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

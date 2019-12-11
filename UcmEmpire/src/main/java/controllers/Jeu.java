package controllers;

import models.Case;
import models.Entity;
import models.Joueur;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Jeu {
    private boolean finTour;
    public Jeu() {
        Joueur joueur = new Joueur();
        Joueur ia = new Joueur();
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
                } else {
                    //Case ressources
                    // TODO: 11-12-19 event selection ressources
                }
                // TODO: 11-12-19 switch sur les actions
                // TODO: 11-12-19 verifier si action possible
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

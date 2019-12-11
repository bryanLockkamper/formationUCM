package controllers;

import models.Entity;
import models.Joueur;
import models.Position;

import java.util.List;
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
        Scanner scanner = new Scanner(System.in);
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

            Position firstPos = new Position(0,0);
            String action = "deplacer";
            Position secondPos = new Position(1,2);

            while (!finTour) {

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

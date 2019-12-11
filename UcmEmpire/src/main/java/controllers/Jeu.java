package controllers;

import models.Entity;
import models.Joueur;

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
        Scanner scanner = new Scanner(System.in);
        while (!victoire | !perdu) {
            //AVANT TOUR
            joueur.construireEntite();
            joueur.recolteRessourcesAuto();
            //TOUR
            finTour = false;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    finTour = true;
                    timer.cancel();
                }
            }, 500);
            while (!finTour) {
            }
            //APRES TOUR
            joueur.deplacementUniteAuto();
            perdu = joueur.aPerdu();
            victoire = ia.aPerdu();
        }
    }
}

package controllers;

import models.Joueur;

import java.util.Timer;
import java.util.TimerTask;

public class Jeu {
    public Jeu() {
        Joueur joueur = new Joueur();
        Joueur ia = new Joueur();
        boolean victoire = false;
        boolean perdu = false;
        while (!victoire | !perdu) {
            //avant tour (ressource)
            //tour

            //après tour (deplacement auto)
            perdu = joueur.aPerdu();
            victoire = ia.aPerdu();
        }
    }
}

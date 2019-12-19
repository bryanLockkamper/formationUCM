package controllers;

import models.*;
import models.Character;
import models.boardPackage.Board;
import models.boardPackage.Square;
import models.units.Soldier;

import java.util.Timer;
import java.util.TimerTask;

public class Game {
    private boolean endRound;
    public Game() {
        Player player = new Player();
        Player ia = new Player();
        Board map = new Board();
        boolean victory = false,
                lost = false;
        Timer timer = new Timer();
        while (!victory | !lost) {
            //AVANT TOUR
            player.buildEntity();
            player.autoHarvestResources();
            //TOUR
            endRound = false;

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    endRound = true;
                }
            }, 500);

            Square<Entity> first = new Square<>(player.getEntity(0)); //TODO : modif placement of the entity because constructor modified
            String action = "move";
            Square<Entity> second = new Square<>(null);

            while (!endRound) {
                if (first.getContent() instanceof Entity) {
                    boolean exist = false;
                    for (int i = 0; i < player.getEntities().size() & !exist; i++)
                        if (player.getEntities().get(i).equals(first.getContent()))
                            exist = true;
                        if (exist)  {
                            switch (action) {
                                case "move":
                                    if (first.getContent() instanceof Character) {
                                        ((Character) first.getContent()).move(1);
                                        //map.move(first, second);
                                    }
                                    // TODO: 11-12-19 event deplacement
                                    break;
                                case "suicide":
                                     if (first.getContent() instanceof Entity)
                                     first.getContent().suicide();
                                     break;
                                case "attack":
                                    if (first.getContent() instanceof Soldier) {
                                        boolean mort = second.getContent().takeDamage(((Soldier)first.getContent()).attack());
                                        if (mort) {
                                         ia.getEntities().remove(second.getContent());
                                         //map.removeEntity(second.); //TODO : récupérer la position de la case
                                        }
                                    }
                                    // TODO: 11-12-19 event attaquer
                                     break;
                                case "create":
                                     // map.setSquare(second); //TODO : récupérer la position de la case
                                     player.addEntity(second.getContent());
                                     break;
                            }
                        }
                }
            }
            timer.purge();

            //APRES TOUR
            player.autoMoveUnits();
            player.maxPa();
            lost = player.hasLost();
            victory = ia.hasLost();
        }
        timer.cancel();
    }
}

package controllers;

import models.Character;
import models.Entity;
import models.Player;

public class TravelChecker {
    public static boolean movableEntity(Entity entity) {
        return entity instanceof Character && ((Character) entity).getPa() > 0;
    }

    public static boolean belongsPlayer(Player player, Entity entity) {
        return player.getEntities().contains(entity);
    }
}

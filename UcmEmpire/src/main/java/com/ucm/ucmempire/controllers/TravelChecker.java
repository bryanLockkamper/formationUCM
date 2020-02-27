package com.ucm.ucmempire.controllers;

import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;

public class TravelChecker {
    public static boolean movableEntity(Entity entity) {
        return entity instanceof Character && ((Character) entity).getPa() > 0;
    }

    public static boolean belongsPlayer(Player player, Entity entity) {
        return player.getEntities().contains(entity);
    }
}

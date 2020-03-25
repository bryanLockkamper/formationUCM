package com.ucm.ucmempire.controllers;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.buildings.Building;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Soldier;

public class CreateEntityChecker {
    public static boolean createEntityChecker(Entity entity) {
        return entity instanceof Soldier && ((Soldier) entity).getPa() > 0;
    }

    public static boolean createEntityChecker(Player player, Building building) {
        return building
                .getRequirement()
                .stream()
                .allMatch(resource -> player.getResources(resource.getResourceName()) >= resource.getHp())
        ;
    }

    public static boolean createEntityChecker(Square square) {
        return square.isBuildable();
    }

    public static boolean createEntityChecker(Entity entity, Square square) {
        return createEntityChecker(entity) && createEntityChecker(square);
    }
}

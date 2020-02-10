package com.ucm.ucmempire.controllers;

import com.ucm.ucmempire.models.units.Builder;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.buildings.Building;

public class CreateEntityChecker {
    public static boolean createEntityChecker(Entity entity) {
        return entity instanceof Builder && ((Builder) entity).getPa() > 0;
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

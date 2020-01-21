package controllers;

import models.Entity;
import models.Player;
import models.boardPackage.Square;
import models.buildings.Building;
import models.units.Builder;

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

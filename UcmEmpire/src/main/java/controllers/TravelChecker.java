package controllers;

import models.Character;
import models.Entity;

public class TravelChecker {
    public static boolean movableEntity(Entity entity) {
        return entity instanceof Character && ((Character) entity).getPa() > 0;
    }
}

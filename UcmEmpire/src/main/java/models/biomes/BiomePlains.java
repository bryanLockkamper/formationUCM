package models.biomes;

import models.Entity;
import models.boardPackage.Square;

public class BiomePlains implements IBiomes {


    public BiomePlains() {
    }

    @Override
    public Square biomeCreation() {

        Square<Entity> entityCase = new Square<>(null, true, true, BiomeType.PLAINS);
        return entityCase;
    }

}

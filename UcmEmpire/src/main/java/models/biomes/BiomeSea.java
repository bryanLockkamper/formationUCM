package models.biomes;

import models.Entity;
import models.boardPackage.Square;

public class BiomeSea implements IBiomes {


    public BiomeSea() {
    }

    @Override
    public Square biomeCreation() {


        Square<Entity> entityCase = new Square<>(null, false, false);

        return entityCase;
    }


}

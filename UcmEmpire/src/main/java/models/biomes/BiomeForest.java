package models.biomes;

import models.Constants;
import models.Entity;
import models.boardPackage.Square;
import models.boardPackage.SpecialSquare;
import models.resources.ResourceName;

import java.util.Random;

public class BiomeForest implements IBiomes {


    public BiomeForest() {

    }

    @Override
    public Square biomeCreation() {

        Random random = new Random();

        if (random.nextInt(Constants.PROBA_TREE) == Constants.PROBA_TREE) {
            SpecialSquare<ResourceName> squareResources = new SpecialSquare<>(ResourceName.WOOD);
            return squareResources;
        } else {
            Square<Entity> squareEntity = new Square<>(null, true, true);
            return squareEntity;
        }

    }


}

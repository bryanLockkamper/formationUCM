package models.biomes;

import models.Constants;
import models.Entity;
import models.boardPackage.Square;
import models.boardPackage.SpecialSquare;
import models.resources.ResourceName;

import java.util.Random;

public class BiomeMountain implements IBiomes {


    public BiomeMountain() {
    }

    @Override
    public Square biomeCreation() {

        Random random = new Random();

        if (random.nextInt(Constants.PROBA_STONE) == Constants.PROBA_STONE) {
            SpecialSquare squareResources = new SpecialSquare(ResourceName.STONE);
            return squareResources;
        } else {

            Square squareEntity = new Square(null, true, true, BiomeType.MOUNTAIN);
            return squareEntity;
        }


    }


}

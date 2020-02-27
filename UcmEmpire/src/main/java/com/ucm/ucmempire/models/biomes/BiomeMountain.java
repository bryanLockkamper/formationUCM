package com.ucm.ucmempire.models.biomes;

import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.resources.ResourceName;
import lombok.EqualsAndHashCode;

import java.util.Random;
@EqualsAndHashCode

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

    @Override
    public String toString() {
        return "BiomeMountain{}";
    }
}

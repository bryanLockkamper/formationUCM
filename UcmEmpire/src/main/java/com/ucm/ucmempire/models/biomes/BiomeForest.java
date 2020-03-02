package com.ucm.ucmempire.models.biomes;

import com.ucm.ucmempire.models.Constants;
import com.ucm.ucmempire.models.boardPackage.Square;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.resources.ResourceName;
import lombok.EqualsAndHashCode;

import java.util.Random;
@EqualsAndHashCode

public class BiomeForest implements IBiomes {


    public BiomeForest() {

    }

    @Override
    public Square biomeCreation() {

        Random random = new Random();

        if (random.nextInt(Constants.PROBA_TREE) == Constants.PROBA_TREE) {
            SpecialSquare squareResources = new SpecialSquare(ResourceName.WOOD);
            return squareResources;
        } else {
            Square squareEntity = new Square(null, true, true, BiomeType.FOREST);
            return squareEntity;
        }

    }

    @Override
    public String toString() {
        return "BiomeForest{}";
    }
}

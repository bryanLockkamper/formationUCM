package models.biomes;

import models.Entity;
import models.boardPackage.Square;

import java.util.ArrayList;

public class BiomeDesert implements IBiomes {


    public BiomeDesert() {
    }

    @Override
    public Square biomeCreation() {
        ArrayList<Square> biome = new ArrayList<>();


        Square squareEntity = new Square(null, true, true, BiomeType.DESERT);

        return squareEntity;
    }


}

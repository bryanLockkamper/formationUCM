package com.ucm.ucmempire.models.biomes;

import com.ucm.ucmempire.models.boardPackage.Square;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
@EqualsAndHashCode
public class BiomeDesert implements IBiomes {


    public BiomeDesert() {
    }

    @Override
    public Square biomeCreation() {
        ArrayList<Square> biome = new ArrayList<>();


        Square squareEntity = new Square(null, true, true, BiomeType.DESERT);

        return squareEntity;
    }

    @Override
    public String toString() {
        return "BiomeDesert{}";
    }
}

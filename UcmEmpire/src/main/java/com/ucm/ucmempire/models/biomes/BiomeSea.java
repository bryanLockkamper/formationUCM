package com.ucm.ucmempire.models.biomes;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.boardPackage.Square;

public class BiomeSea implements IBiomes {


    public BiomeSea() {
    }

    @Override
    public Square biomeCreation() {


        Square entityCase = new Square(null, false, false, BiomeType.SEA);

        return entityCase;
    }


}
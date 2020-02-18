package com.ucm.ucmempire.models.biomes;

import com.ucm.ucmempire.models.boardPackage.Square;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode

public class BiomeSea implements IBiomes {


    public BiomeSea() {
    }

    @Override
    public Square biomeCreation() {


        Square entityCase = new Square(null, false, false, BiomeType.SEA);

        return entityCase;
    }


}

package com.ucm.ucmempire.models.biomes;

import com.ucm.ucmempire.models.boardPackage.Square;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode

public class BiomePlains implements IBiomes {


    public BiomePlains() {
    }

    @Override
    public Square biomeCreation() {

        Square entityCase = new Square(null, true, true, BiomeType.PLAINS);
        return entityCase;
    }

    @Override
    public String toString() {
        return "BiomePlains{}";
    }
}

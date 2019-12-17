package models.biomes;

import models.Entity;
import models.BoardPackage.Case;

import java.util.ArrayList;

public class BiomeDesert implements IBiomes {


    public BiomeDesert() {
    }

    @Override
    public Case creationBiome() {
        ArrayList<Case> biome = new ArrayList<>();


        Case<Entity> entityCase = new Case<>(null, true, true);

        return entityCase;
    }


}

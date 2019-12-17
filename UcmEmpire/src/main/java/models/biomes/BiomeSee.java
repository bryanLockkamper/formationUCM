package models.biomes;

import models.Entity;
import models.BoardPackage.Case;

public class BiomeSee implements IBiomes {


    public BiomeSee() {
    }

    @Override
    public Case creationBiome() {


        Case<Entity> entityCase = new Case<>(null, false, false);

        return entityCase;
    }


}

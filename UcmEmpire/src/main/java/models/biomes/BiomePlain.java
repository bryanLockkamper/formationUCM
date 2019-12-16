package models.biomes;

import models.Entity;
import models.Plateau.Case;

public class BiomePlain implements IBiomes {


    public BiomePlain() {
    }

    @Override
    public Case creationBiome() {

        Case<Entity> entityCase = new Case<>(null, true, true);
        return entityCase;
    }

}

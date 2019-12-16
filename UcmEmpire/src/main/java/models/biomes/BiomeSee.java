package models.biomes;

import models.Constantes;
import models.Entity;
import models.Plateau.Case;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BiomeSee implements IBiomes {


    public BiomeSee() {
    }

    @Override
    public Case creationBiome() {


        Case<Entity> entityCase = new Case<>(null, false, false);

        return entityCase;
    }


}

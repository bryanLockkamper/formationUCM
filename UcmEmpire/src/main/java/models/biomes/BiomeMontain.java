package models.biomes;

import models.Constantes;
import models.Entity;
import models.Plateau.Case;
import models.Plateau.CaseSpecial;

import java.util.ArrayList;
import java.util.Random;

public class BiomeMontain implements IBiomes {


    public BiomeMontain() {
    }

    @Override
    public Case creationBiome() {

        Random random = new Random();

        if (random.nextInt(Constantes.PROBA_STONE) == Constantes.PROBA_STONE) {
            CaseSpecial<EnumRessourcersTemp> ressourceCase = new CaseSpecial<>(EnumRessourcersTemp.PIERRE);
            return ressourceCase;
        } else {

            Case<Entity> entityCase = new Case<>(null, true, true);
            return entityCase;
        }


    }


}

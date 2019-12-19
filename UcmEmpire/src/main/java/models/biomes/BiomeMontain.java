package models.biomes;

import models.Constantes;
import models.Entity;
import models.BoardPackage.Case;
import models.BoardPackage.CaseSpecial;
import models.ressources.RessourceName;

import java.util.Random;

public class BiomeMontain implements IBiomes {


    public BiomeMontain() {
    }

    @Override
    public Case creationBiome() {

        Random random = new Random();

        if (random.nextInt(Constantes.PROBA_STONE) == Constantes.PROBA_STONE) {
            CaseSpecial<RessourceName> ressourceCase = new CaseSpecial<>(RessourceName.PIERRE);
            return ressourceCase;
        } else {

            Case<Entity> entityCase = new Case<>(null, true, true);
            return entityCase;
        }


    }


}

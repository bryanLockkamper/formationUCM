package models.biomes;

import models.Constantes;
import models.Entity;
import models.BoardPackage.Case;
import models.BoardPackage.CaseSpecial;
import models.ressources.RessourceName;

import java.util.Random;

public class BiomeForest implements IBiomes {


    public BiomeForest() {

    }

    @Override
    public Case creationBiome() {

        Random random = new Random();

        if (random.nextInt(Constantes.PROBA_TREE) == Constantes.PROBA_TREE) {
            CaseSpecial<RessourceName> ressourceCase = new CaseSpecial<>(RessourceName.BOIS);
            return ressourceCase;
        } else {
            Case<Entity> entityCase = new Case<>(null, true, true);
            return entityCase;
        }

    }


}

package models.biomes;
import models.Entity;
import models.Plateau.Case;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BiomeEau implements IBiomes {

    public BiomeEau() {
    }

    @Override
    public ArrayList<Case> creationBiome() {

        ArrayList<Case> biomeEau = new ArrayList<>();

        for (int i = 0; i < Constantes.DIMENSION * Constantes.DIMENSION ; i++) {

            Case<Entity> entityCase = new Case<>(null,false,false);

        }

        return null;
    }
}

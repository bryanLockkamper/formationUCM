package models;

import models.batiments.Grenier;
import models.ressources.Ressource;
import models.ressources.RessourceName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Joueur {
    private final int capaciteGrenier = 20;
    protected String name;
    protected Map<RessourceName, Integer> ressources;
    protected List<Entity> entities;

    public Joueur(){
        ressources = new HashMap<>();
        ressources.put(RessourceName.BOIS, 0);
        ressources.put(RessourceName.PIERRE, 0);
        ressources.put(RessourceName.NOURRITURE, 0);

        entities = new ArrayList<>();
    }

    public int getMaxRessources(){
        int nbGreniers = 0;
        for (int i = 0; i < entities.size() ; i++) {
            if(entities.get(i) instanceof Grenier){
                nbGreniers++;
            }
        }

        return nbGreniers*capaciteGrenier;
    }

    public int getRessources(RessourceName ressourceName){
            return ressources.get(ressourceName);
    }
}

package models;

import models.batiments.Grenier;
import models.ressources.Ressource;
import models.ressources.RessourceName;

import java.util.ArrayList;
import java.util.HashMap;
import models.batiments.BatimentInterfaces.IBatimentProd;
import models.unite.Paysan;
import models.unite.UnitInterface.IPaysan;

import java.util.ArrayList;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public boolean aPerdu() {
        return true;
    }

    public void deplacementUniteAuto() {
        for (Entity entity : entities) {
            if (entity instanceof Personnage)
                ((Personnage) entity).deplacementAuto();
        }
    }

    public void construireEntite() {
        for (Entity entity : entities) {
            if (entity instanceof IBatimentProd)
                if (((IBatimentProd) entity).decrementCompteur() != null)
                    entities.add(entity);
        }
    }

    public void recolteRessourcesAuto() {
        for (Entity entity : entities) {
            if (entity instanceof IPaysan)
                ressources.put(((Paysan)entity).getRessourceARecolter(),((Paysan)entity).recolter());
        }
    }

    public void maxPa() {
        for (Entity entity : entities) {
            if (entity instanceof Personnage)
                ((Personnage)entity).setPaMax();
        }
    }

    public Entity getEntity(int i) {
        return entities.get(i);
    }

    public void addEntity(Entity content) {
    }
}

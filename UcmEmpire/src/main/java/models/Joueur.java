package models;

<<<<<<< HEAD
import models.batiments.BatimentInterfaces.IBatimentProd;
import models.unite.Paysan;
import models.unite.UnitInterface.IPaysan;

=======
import java.util.ArrayList;
>>>>>>> 43ba58ee63c026fac2f39da833f421584149cef0
import java.util.List;

public class Joueur {
    protected String name;
    protected List<Ressource> ressources;
    protected List<Entity> entities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ressource> getRessources() {
        return ressources;
    }

    public void setRessources(List<Ressource> ressources) {
        this.ressources = ressources;
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
<<<<<<< HEAD
        for (Entity entity : entities) {
            if (entity instanceof IPaysan);
                //getRessource dans map puis add int
//                ((Paysan) entity).recolter();
        }
    }

    public void maxPa() {
        for (Entity entity : entities) {
            if (entity instanceof Personnage)
                ((Personnage)entity).setPaMAx();
        }
=======

>>>>>>> 43ba58ee63c026fac2f39da833f421584149cef0
    }
}

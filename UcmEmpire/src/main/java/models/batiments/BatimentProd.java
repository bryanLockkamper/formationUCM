package models.batiments;

import models.Entity;
import models.Personnage;
import models.ressources.Ressource;
import models.batiments.BatimentInterfaces.IBatimentProd;
import models.batiments.BatimentInterfaces.ICaserne;
import models.batiments.BatimentInterfaces.IForum;
import models.unite.Constructeur;
import models.unite.Paysan;
import models.unite.Soldat;
import models.unite.UnitInterface.IConstructeur;
import models.unite.UnitInterface.IPaysan;
import models.unite.UnitInterface.ISoldat;

import java.util.ArrayList;
import java.util.List;

public abstract class BatimentProd extends Batiment implements IBatimentProd {

    public static final int PAYSAN_ENTITY =1;
    public static final int CONSTRUCTEUR_ENTITY =2;
    public static final int SOLDAT_ENTITY =3;

    private int compteur;
    private List<Entity> prod;

    public BatimentProd(int pv, String name, List<Ressource> requirement) {
        super(pv, name, requirement);
        prod = new ArrayList<>();
    }

    public Entity getUnit(int typeProd){
        Personnage personnage = null;

        if (this instanceof IForum)
        {
            switch (typeProd){
                case PAYSAN_ENTITY:
                    personnage = new Paysan( 10 , "Guetno" , 10);
                    break;
                case CONSTRUCTEUR_ENTITY:
                    personnage = new Constructeur(10 , "Constructeur" , 10);
                    break;
                default:
                    throw new IllegalArgumentException("Type incorrecte");
            }

        }
         else if (this instanceof ICaserne)
        {
            switch (typeProd)
            {
                case SOLDAT_ENTITY:
                    personnage = new Soldat(15 , "Perceval" , 10);
                    break;
                default:
                    throw new IllegalArgumentException("Type incorrecte");
            }
        }

        return personnage;
    }

    @Override
    public List<Entity> getEntities() {
        return prod;
    }

    @Override
    public Entity decrementCompteur() {
        return null;
    }

    @Override
    public void setEntities(List<Entity> entities) {
        this.prod = entities;
    }

}

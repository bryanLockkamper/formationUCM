package services;

import com.sun.xml.internal.bind.v2.TODO;
import models.Entity;
import models.Player;
import models.boardPackage.SpecialSquare;
import models.resources.Resource;
import models.units.Farmer;
import models.units.unitInterfaces.IFarmer;

import java.util.List;
import java.util.stream.Collectors;

public class HarvestService {

    public int autoHarvestResources( SpecialSquare squareResource, Player player) {

        List<Farmer> farmers = player.getEntities().stream().filter(entity -> entity instanceof Farmer).map(entity -> (Farmer)entity).collect(Collectors.toList());

        if (squareResource != null) {
            for (Farmer farmer : farmers) {
                if (squareResource.getResourceQuantity() >= 0) {
                    int actualResource = player.getResources(((Resource) squareResource.getContent()).getResourceName());
                    int harvest = farmer.getPa();

                    if (squareResource.getResourceQuantity() - harvest >= 0)
                        squareResource.setResourceQuantity(squareResource.getResourceQuantity() - harvest);

                    else {
                        harvest = squareResource.getResourceQuantity();
                        squareResource.setResourceQuantity(0);
                    }

                    if (player.getMaxResources() + harvest <= player.getMaxResources())
                        player.getResources().add(new Resource(((Farmer) farmer).getResourceHarvesting(), harvest + actualResource));

                    else {
                        player.getResources().add(new Resource(((Farmer) farmer).getResourceHarvesting(), player.getMaxResources()));
                    }

                    farmer.setPa(0);

                    return harvest;
                }
            }
        }
        return 0;
    }
}

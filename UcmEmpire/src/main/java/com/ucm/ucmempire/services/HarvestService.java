package com.ucm.ucmempire.services;

import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;

import java.util.List;
import java.util.stream.Collectors;

public class HarvestService {

    public int autoHarvestResources( SpecialSquare squareResource, Player player) {

        List<Farmer> farmers = player.getEntities().stream().filter(entity -> entity instanceof Farmer).map(entity -> (Farmer)entity).collect(Collectors.toList());
        int harvest =0;

        if (squareResource != null) {
            for (Farmer farmer : farmers) {
                if (squareResource.getResourceQuantity() >= 0) {
                    ResourceName actualResource = player.getResources().stream().filter(); //TODO DAMIEN : need to actualize the harvest meth to 1) find the name and 2) actualize the quantity for the player with the enum change
                    harvest += farmer.getPa();

                    if (squareResource.getResourceQuantity() - harvest >= 0)
                        squareResource.setResourceQuantity(squareResource.getResourceQuantity() - harvest);

                    else {
                        harvest = squareResource.getResourceQuantity();
                        squareResource.setResourceQuantity(0);
                    }

                    if (player.getMaxResources() + harvest <= player.getMaxResources())
                        //player.getResources().add(new Resource(((Farmer) farmer).getResourceHarvesting(), harvest + actualResource));
                    {
                        player.getResources().stream()

                    }

                    else {
                        player.getResources().add(new Resource(((Farmer) farmer).getResourceHarvesting(), player.getMaxResources()));
                    }

                    farmer.setPa(0);

                    return harvest;
                }
            }
        }
        return harvest;
    }
}

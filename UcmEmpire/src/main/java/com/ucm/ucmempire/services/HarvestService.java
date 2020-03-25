package com.ucm.ucmempire.services;

import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;

import java.util.List;
import java.util.stream.Collectors;

public class HarvestService {

    public int autoHarvestResources(SpecialSquare squareResource, Player player) {

        int harvest = 0;
        int harvestTotal = 0;

        if (player.getEntities() != null) {
            List<Farmer> playerFarmerList = player.getEntities().stream()
                    .filter(entity -> entity instanceof Farmer)
                    .map(entity -> (Farmer) entity)
                    .collect(Collectors.toList());
            if (squareResource.getFarmers() != null) {
                List<Farmer> farmers = squareResource.getFarmers().stream()
                        .filter(farmer -> (playerFarmerList.contains(farmer)) && (farmer.getIdUser() == player.getId()))
                        .collect(Collectors.toList());

                Resource actualResource = player.getResources().stream()
                        .filter(resource -> resource.getResourceName().getType().equals(((Resource) squareResource.getContent()).getNameOfRessource()))
                        .findFirst().orElseThrow(NullPointerException::new);


                for (Farmer farmer : farmers) {
                    if (squareResource.getContent().getHp() >= 0) {

                        harvest = farmer.getPa();
                        harvestTotal += harvest;

                        //on ajoute les ressources farmée à l'inventaire du fermier
                        ResourceName farmerResource = actualResource.getResourceName();
                        farmer.getInventory().put(farmerResource, farmer.getInventory().get(farmerResource) + harvest);


                        if ((squareResource.getContent().getHp() - harvest) >= 0)
                            squareResource.getContent().setHp(squareResource.getContent().getHp() - harvest);

                        else {
                            harvest = squareResource.getContent().getHp();
                            squareResource.getContent().setHp(0);
                        }

                        farmer.setPa(0);
                    }
                }

                if (player.getResource(actualResource.getResourceName()).getHp() + harvestTotal <= player.getMaxResources()) {
                    player.getResource(actualResource.getResourceName()).setHp(actualResource.getHp() + harvestTotal);
                } else {
                    player.getResource(actualResource.getResourceName()).setHp((player.getMaxResources()));
                }
            }
        }

        return harvestTotal;
    }
}
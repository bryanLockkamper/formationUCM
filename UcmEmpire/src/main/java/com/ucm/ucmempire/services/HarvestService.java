package com.ucm.ucmempire.services;

import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.units.Farmer;

import java.util.List;
import java.util.stream.Collectors;

public class HarvestService {

    public int autoHarvestResources( SpecialSquare squareResource, Player player) {


        List<Farmer> farmers = squareResource.getFarmers().stream()
                .filter(farmer -> farmer.getIdUser() == player.getId())
                .collect(Collectors.toList());

        int harvest =0;

        for (Farmer farmer : farmers) {
            if (squareResource.getResourceQuantity() >= 0) {
                Resource actualResource = player.getResources().stream()
                        .filter(resource -> resource.getResourceName().getType().equals(((Resource)squareResource.getContent()).getNameOfRessource()))
                        .findFirst().orElseThrow(NullPointerException::new);
                harvest += farmer.getPa();
                System.out.println(harvest);
                System.out.println(player.getEntities().toString());

                if (squareResource.getResourceQuantity() - harvest >= 0)
                    squareResource.setResourceQuantity(squareResource.getResourceQuantity() - harvest);

                else {
                    harvest = squareResource.getResourceQuantity();
                    squareResource.setResourceQuantity(0);
                }

                player.getResources().remove(actualResource);

                if (player.getMaxResources() + harvest <= player.getMaxResources()) {
                    actualResource.setHp(actualResource.getHp()+ harvest);
                }

                else {
                    actualResource.setHp(player.getMaxResources());
                }

                player.getResources().add(actualResource);
                farmer.setPa(0);
            }
        }
        return harvest;
    }
}

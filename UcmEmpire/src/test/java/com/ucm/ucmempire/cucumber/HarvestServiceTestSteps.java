package com.ucm.ucmempire.cucumber;

import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.boardPackage.SpecialSquare;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Farmer;
import com.ucm.ucmempire.services.HarvestService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class HarvestServiceTestSteps {
    private Player player;
    private Integer nbFarmers;
    private List<Farmer> farmerList;
    private SpecialSquare square;

    private HarvestService harvestService = new HarvestService();
    private Integer result = 0;

    @Given("a Player {player}")
    public void a_player(Player player)
    {
        this.player = player;
    }

    //And 3 Farmers pa:10|hp:10|idPlayer:1
    @Given("{int} Farmers who have {int} pa each and {int} hp and belongs to player {int}")
    public void add_farmers_to_player(Integer nbFarmers , Integer nbPa, Integer nbHp, Integer idPlayer)
    {
        this.nbFarmers = nbFarmers;
        this.farmerList = new ArrayList<>();

        int nb =0;

        for (int i = 0; i < nbFarmers; i++) {
            Farmer farmer = new Farmer(idPlayer, nbHp , nbPa);
            farmerList.add(farmer);
            player.addEntity(farmer);
        }
    }

    @Given("Farmers are on a Square with {int} {string} Resource")
    public void add_farmers_to_square(Integer nbRes , String resourceName)
    {
        ResourceName rn = resourceName.equals("Stone") ? ResourceName.STONE : null;
        Resource resource = new Resource(rn , nbRes);
        square = new SpecialSquare(rn);
        resource.setMaxHP(nbRes);
        for (Farmer f : farmerList) {
            square.addFarmer(f);
        }
    }

    @When("I end my turn Farmers have to harvest as much resource as their number of action point")
    public void farmers_autoHarvest()
    {
        result = harvestService.autoHarvestResources(square , player);
    }

    @Then("the result should be {int}")
    public void result_equal(Integer result)
    {
        Assert.assertEquals(result , this.result);
    }
}

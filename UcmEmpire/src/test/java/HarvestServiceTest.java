import models.Entity;
import models.Player;
import models.boardPackage.SpecialSquare;
import models.resources.ResourceName;
import models.units.Farmer;
import org.junit.Test;
import services.HarvestService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HarvestServiceTest {

    HarvestService harvestService = new HarvestService();

    @Test
    public void harvestNormalCase_true(){

        //Arrange
        Player p1 = new Player();
        Farmer f1 = new Farmer(10,"peont", 10 );
        Farmer f2 = new Farmer(10,"peont1", 10 );
        Farmer f3 = new Farmer(10,"peont2", 10 );
        SpecialSquare square = new SpecialSquare(ResourceName.STONE);
        square.setResourceQuantity(Integer.MAX_VALUE);
        List<Entity> list = new ArrayList<>();

        list.add(f1);
        list.add(f2);
        list.add(f3);
        p1.setEntities(list);
        //Act
        Integer nb = harvestService.autoHarvestResources(square,p1);

        //Assert
        assertEquals(10, (int)nb);
    }

}
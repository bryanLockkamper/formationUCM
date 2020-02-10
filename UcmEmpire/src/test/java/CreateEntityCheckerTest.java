import controllers.CreateEntityChecker;
import models.Player;
import models.buildings.Forum;
import models.resources.Resource;
import models.resources.ResourceName;
import models.units.Builder;
import models.units.Farmer;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.*;

public class CreateEntityCheckerTest {

   /* @Test //TODO : BRYAN
    public void createEntityChecker_Builder_20pa_true() {
        Assert.assertTrue(CreateEntityChecker.createEntityChecker(new Builder(20, "test", 20)));
    }

    @Test
    public void createEntityChecker_Builder_0pa_false() {
        Assert.assertFalse(CreateEntityChecker.createEntityChecker(new Builder(20, "test", 0)));
    }

    @Test
    public void createEntityChecker_OtherBuilder_20pa_false() {
        Assert.assertFalse(CreateEntityChecker.createEntityChecker(new Farmer(20, "test", 20)));
    }

    @Test
    public void createEntityChecker_resourcePlayer_equals_requirement_Builder_Forum_true() {
        Player player = new Player();
        HashSet<Resource> map = new HashSet<>();
        map.add(new Resource(ResourceName.STONE, 5));
        map.add(new Resource(ResourceName.WOOD, 5));
        map.add(new Resource(ResourceName.FOOD, 5));
        player.setResources(map);

        HashSet<Resource> map2 = new HashSet<>();
        map2.add(new Resource(ResourceName.STONE, 5));
        map2.add(new Resource(ResourceName.WOOD, 5));

        assertTrue(CreateEntityChecker.createEntityChecker(player, new Forum(20, "test", map2)));
    }

    @Test
    public void createEntityChecker_resourcePlayer_up_requirement_Builder_Forum_Required_true() {
        Player player = new Player();
        HashSet<Resource> map = new HashSet<>();
        map.add(new Resource(ResourceName.STONE, 6));
        map.add(new Resource(ResourceName.WOOD, 6));
        map.add(new Resource(ResourceName.FOOD, 6));
        player.setResources(map);

        HashSet<Resource> map2 = new HashSet<>();
        map2.add(new Resource(ResourceName.STONE, 5));
        map2.add(new Resource(ResourceName.WOOD, 5));

        assertTrue(CreateEntityChecker.createEntityChecker(player, new Forum(20, "test", map2)));
    }

    @Test
    public void createEntityChecker_resourcePlayer_down_requirement_Builder_Forum_Required_false() {
        Player player = new Player();
        HashSet<Resource> map = new HashSet<>();
        map.add(new Resource(ResourceName.STONE, 5));
        map.add(new Resource(ResourceName.WOOD, 4));
        player.setResources(map);

        HashSet<Resource> map2 = new HashSet<>();
        map2.add(new Resource(ResourceName.STONE, 5));
        map2.add(new Resource(ResourceName.WOOD, 5));

        assertFalse(CreateEntityChecker.createEntityChecker(player, new Forum(20, "test", map2)));
    }*/
}
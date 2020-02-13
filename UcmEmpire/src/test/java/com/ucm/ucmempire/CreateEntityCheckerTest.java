package com.ucm.ucmempire;

import com.ucm.ucmempire.controllers.CreateEntityChecker;
import com.ucm.ucmempire.models.Player;
import com.ucm.ucmempire.models.buildings.Forum;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.resources.ResourceName;
import com.ucm.ucmempire.models.units.Builder;
import com.ucm.ucmempire.models.units.Farmer;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CreateEntityCheckerTest {

    @Test
    public void createEntityChecker_Builder_20pa_true() {
        Assert.assertTrue(CreateEntityChecker.createEntityChecker(new Builder(20, 0, 20)));
    }

    @Test
    public void createEntityChecker_Builder_0pa_false() {
        Assert.assertFalse(CreateEntityChecker.createEntityChecker(new Builder(20, 0, 0)));
    }

    @Test
    public void createEntityChecker_OtherBuilder_20pa_false() {
        Assert.assertFalse(CreateEntityChecker.createEntityChecker(new Farmer(20, 0, 20)));
    }

    @Test
    public void createEntityChecker_resourcePlayer_equals_requirement_Builder_Forum_true() {
        Player player = new Player();
        Set<Resource> map = new HashSet<>();
        map.add(new Resource(ResourceName.STONE, 5));
        map.add(new Resource(ResourceName.WOOD, 5));
        map.add(new Resource(ResourceName.FOOD, 5));
        player.setResources(map);

        HashSet<Resource> map2 = new HashSet<>();
        map2.add(new Resource(ResourceName.STONE, 5));
        map2.add(new Resource(ResourceName.WOOD, 5));

        assertTrue(CreateEntityChecker.createEntityChecker(player, new Forum(20, 0, map2)));
    }

    @Test
    public void createEntityChecker_resourcePlayer_up_requirement_Builder_Forum_Required_true() {
        Player player = new Player();
        Set<Resource> map = new HashSet<>();
        map.add(new Resource(ResourceName.STONE, 6));
        map.add(new Resource(ResourceName.WOOD, 6));
        map.add(new Resource(ResourceName.FOOD, 6));
        player.setResources(map);

        HashSet<Resource> map2 = new HashSet<>();
        map2.add(new Resource(ResourceName.STONE, 5));
        map2.add(new Resource(ResourceName.WOOD, 5));

        assertTrue(CreateEntityChecker.createEntityChecker(player, new Forum(20, 0, map2)));
    }

    @Test
    public void createEntityChecker_resourcePlayer_down_requirement_Builder_Forum_Required_false() {
        Player player = new Player();
        Set<Resource> map = new HashSet<>();
        map.add(new Resource(ResourceName.STONE, 5));
        map.add(new Resource(ResourceName.WOOD, 4));
        player.setResources(map);

        HashSet<Resource> map2 = new HashSet<>();
        map2.add(new Resource(ResourceName.STONE, 5));
        map2.add(new Resource(ResourceName.WOOD, 5));

        assertFalse(CreateEntityChecker.createEntityChecker(player, new Forum(20, 0, map2)));
    }
}
package com.ucm.ucmempire;

import com.ucm.ucmempire.controllers.TravelChecker;
import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.buildings.Forum;
import com.ucm.ucmempire.models.units.Farmer;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TravelCheckerTest {

    @Test
    public void movableEntity_Character_20pa_true() {
        assertTrue(TravelChecker.movableEntity(new Character(20, 0, 20)));
    }

    @Test
    public void movableEntity_Farmer_20pa_true() {
        assertTrue(TravelChecker.movableEntity(new Farmer(20, 0, 20)));
    }

    @Test
    public void movableEntity_Character_0pa_false() {
        assertFalse(TravelChecker.movableEntity(new Character(20, 0, 0)));
    }

    @Test
    public void movableEntity_Forum_0pa_false() {
        assertFalse(TravelChecker.movableEntity(new Forum(20, 0, null)));
    }
}
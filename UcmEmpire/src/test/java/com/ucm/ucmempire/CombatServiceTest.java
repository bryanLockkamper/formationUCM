package com.ucm.ucmempire;

import com.ucm.ucmempire.models.units.Soldier;
import org.junit.Test;
import org.junit.runners.Parameterized;
import com.ucm.ucmempire.services.CombatService;

import static org.junit.Assert.*;

public class CombatServiceTest {

    CombatService combatService = new CombatService();

    @Test
    public void fightNormalCase_True() {

        //Arrange
        Soldier attack = new Soldier(5, 1, 5, 5);
        Soldier defense = new Soldier(5, 2, 5, 5);


        assertTrue(CombatService.fight(attack, defense));

    }

    @Test
    // TODO: 18/03/2020 C'est quoi une normal case ? 
    public void fightNormalCase_False() {

        //Arrange
        Soldier attack = new Soldier(10, 1, 10, 5);
        Soldier defense = new Soldier(10, 2, 10, 5);
        //Act

        boolean isCorrect = CombatService.fight(attack, defense);

        //Assert

        assertFalse(isCorrect);

    }

    @Test
    public void fightAnormalCaseNullAttack_False() {

        //Arrange
        Soldier defense = new Soldier(5, 2, 5, 5);

        //Act

        Boolean isCorrect = combatService.fight(null, defense);

        //Assert

        assertFalse(isCorrect);

    }

    @Test
    public void fightAnormalCaseNullDef_False() {

        //Arrange
        Soldier attack = new Soldier(5, 1, 5, 5);

        //Act

        Boolean isCorrect = combatService.fight(attack, null);

        //Assert

        assertFalse(isCorrect);

    }
}
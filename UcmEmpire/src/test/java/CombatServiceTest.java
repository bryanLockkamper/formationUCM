import models.units.Soldier;
import org.junit.Test;
import org.junit.runners.Parameterized;
import services.CombatService;

import static org.junit.Assert.*;

public class CombatServiceTest {

    CombatService combatService = new CombatService();

    @Test
    public void fightNormalCase_True() {

        //Arrange
        Soldier attack = new Soldier(5, "attack", 5, 5);
        Soldier defense = new Soldier(5, "defense", 5, 5);
        //Act

        Boolean isCorrect = combatService.fight(attack, defense);

        //Assert

        assertTrue(isCorrect);

    }

    @Test
    public void fightNormalCase_False() {

        //Arrange
        Soldier attack = new Soldier(10, "attack", 10, 5);
        Soldier defense = new Soldier(10, "defense", 10, 5);
        //Act

        Boolean isCorrect = combatService.fight(attack, defense);

        //Assert

        assertFalse(isCorrect);

    }

    @Test
    public void fightAnormalCaseNullAttack_False() {

        //Arrange
        Soldier defense = new Soldier(5, "defense", 5, 5);

        //Act

        Boolean isCorrect = combatService.fight(null, defense);

        //Assert

        assertFalse(isCorrect);

    }

    @Test
    public void fightAnormalCaseNullDef_False() {

        //Arrange
        Soldier attack = new Soldier(5, "attack", 5, 5);

        //Act

        Boolean isCorrect = combatService.fight(attack, null);

        //Assert

        assertFalse(isCorrect);

    }
}
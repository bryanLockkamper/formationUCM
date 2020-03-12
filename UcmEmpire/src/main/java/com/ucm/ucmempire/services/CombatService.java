package com.ucm.ucmempire.services;

import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.units.Soldier;

public class CombatService {

    public static boolean fight(Soldier attack , Entity defense){

        if (attack != null && defense != null)
        {
            defense.setHp(defense.getHp() - attack.getDamage());
            return defense.getHp() <= 0;
        }

        return false;
    }
}

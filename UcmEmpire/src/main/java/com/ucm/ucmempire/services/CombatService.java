package com.ucm.ucmempire.services;

import com.ucm.ucmempire.models.units.Soldier;

public class CombatService {

    public boolean fight(Soldier attack , Soldier defense){

        if (attack != null && defense != null)
        {
            defense.setHp(attack.getDamage());
            return defense.getHp() <= 0;
        }

        return false;
    }

//    public boolean takeDamage(int damage){
//        setHp(getHp()-damage);
//        return getHp() <= 0;
//    }
//
//    public int attack(){
//        return getPa();
//    }
//
//
//    public void suicide() {
//        this.hp = 0;
//    }
}

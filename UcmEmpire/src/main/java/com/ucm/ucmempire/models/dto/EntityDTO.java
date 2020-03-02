package com.ucm.ucmempire.models.dto;

import com.ucm.ucmempire.models.Character;
import com.ucm.ucmempire.models.Entity;
import com.ucm.ucmempire.models.buildings.*;
import com.ucm.ucmempire.models.resources.Resource;
import com.ucm.ucmempire.models.units.Builder;
import com.ucm.ucmempire.models.units.Farmer;
import com.ucm.ucmempire.models.units.Soldier;
import javassist.expr.Instanceof;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Required;

import java.util.Objects;


public class EntityDTO {

    private int idPlayer;
    private String typeEntity; //TODO : Need to define into Swagger a pattern (@Pattern ?) for angular knows wich type avaible
    private int hp;
    private int pa;
    private int maxPa;
    private int damage;
    private String typeRessource;

    public EntityDTO() {
    }

    public EntityDTO(Entity entity)
    {
        this.hp = entity.getHp();


        if (entity instanceof Character)
        {
            this.pa = ((Character) entity).getPa();
            this.maxPa = ((Character) entity).getMaxPA();
            this.idPlayer = ((Character) entity).getIdUser();

            if (entity instanceof Soldier) {
                this.typeEntity = TypeEntity.SOLDIER.getType();
                this.damage = ((Soldier) entity).getDamage();}
            else if (entity instanceof Farmer) { this.typeEntity = TypeEntity.FARMER.getType(); }
            else if (entity instanceof Builder) { this.typeEntity = TypeEntity.BUILDER.getType(); }
            else this.typeEntity = "CHARACTER";

        } else if (entity instanceof Building)
        {
            this.idPlayer = ((Building) entity).getIdUser();
            //TODO DAMIEN : RESSOURCE IN FORUM AND GRANARY

            if (entity instanceof House) { this.typeEntity = TypeEntity.HOUSE.getType();}
            else if (entity instanceof Granary) { this.typeEntity = TypeEntity.GRANARY.getType();}
            else if (entity instanceof Forum) { this.typeEntity = TypeEntity.FORUM.getType();}
            else if (entity instanceof Barracks) { this.typeEntity = TypeEntity.BARACKS.getType();}
            else this.typeEntity = "BUILDING";
        } else
        {
            this.typeEntity = TypeEntity.RESSOURCE.getType();

            this.typeRessource = ((Resource) entity).getResourceName().getType();
        }


    }

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getTypeEntity() {
        return typeEntity;
    }

    public void setTypeEntity(String typeEntity) {
        this.typeEntity = typeEntity;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public int getMaxPa() {
        return maxPa;
    }

    public void setMaxPa(int maxPa) {
        this.maxPa = maxPa;
    }

    public String getTypeRessource() {
        return typeRessource;
    }

    public void setTypeRessource(String typeRessource) {
        this.typeRessource = typeRessource;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "EntityDTO{" +
                "idPlayer=" + idPlayer +
                ", typeEntity='" + typeEntity + '\'' +
                ", hp=" + hp +
                ", pa=" + pa +
                ", maxPa=" + maxPa +
                ", damage=" + damage +
                ", typeRessource='" + typeRessource + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityDTO)) return false;
        EntityDTO entityDTO = (EntityDTO) o;
        return getIdPlayer() == entityDTO.getIdPlayer() &&
                getHp() == entityDTO.getHp() &&
                getPa() == entityDTO.getPa() &&
                getMaxPa() == entityDTO.getMaxPa() &&
                getDamage() == entityDTO.getDamage() &&
                Objects.equals(getTypeEntity(), entityDTO.getTypeEntity()) &&
                Objects.equals(getTypeRessource(), entityDTO.getTypeRessource());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPlayer(), getTypeEntity(), getHp(), getPa(), getMaxPa(), getDamage(), getTypeRessource());
    }
}

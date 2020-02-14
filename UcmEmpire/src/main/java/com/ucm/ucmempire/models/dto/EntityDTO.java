package com.ucm.ucmempire.models.dto;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Required;

@Data
public class EntityDTO {

    private int idPlayer;
    private String typeEntity; //TODO : Need to define into Swagger a pattern (@Pattern ?) for angular knows wich type avaible
    private int hp;
    private int pa;
    private int maxPa;
    private int quantityHarvest;
    private String typeRessource;


}

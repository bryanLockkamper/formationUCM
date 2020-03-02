package com.ucm.ucmempire.models.dto;

public enum TypeEntity {

    FARMER ("Farmer"),
    SOLDIER ("Soldier"),
    BUILDER("Builder"),
    BARACKS("Baracks"),
    FORUM("Forum"),
    GRANARY("Granary"),
    HOUSE("House"),
    RESSOURCE("Ressource");

    private String type;
     public String getType() {return type;}

     TypeEntity(String type) {
         this.type = getType();
     }
}

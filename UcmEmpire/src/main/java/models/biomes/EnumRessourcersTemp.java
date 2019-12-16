package models.biomes;

public enum EnumRessourcersTemp { // TODO : temporary enum, need to replace with the true enum

    BOIS("bois"),
    PIERRE("pierre"),
    EAU("water"),
    DESERT("desert"); //TODO : quantity set to a number and not infinity

    private String type;

    EnumRessourcersTemp(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

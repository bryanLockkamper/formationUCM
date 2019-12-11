package models.biomes;

public enum EnumRessourcersTemp {

    BOIS ("bois"),
    PIERRE ("pierre");

    private String type;

    EnumRessourcersTemp(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

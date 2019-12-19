package models.biomes;

public enum BiomeType {

    PLAIN("plain"),
    MOUNTAIN("mountain"),
    SEA("sea"),
    DESERT("desert"),
    FOREST("forest");

    private String type;

    public String getType() {
        return type;
    }

    BiomeType(String type) {
        this.type = getType();
    }
}

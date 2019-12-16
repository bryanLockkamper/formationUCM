package models.biomes;

public enum BiomeType {

    PLAIN("plain"),
    MONTAIN("montain"),
    SEE("see"),
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

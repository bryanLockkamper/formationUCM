package models.biomes;

public class BiomeFactory {

    public BiomeFactory() {

    }

    public IBiomes getBiome(BiomeType biomeType) {
        switch (biomeType) {
            case SEA:
                return new BiomeSea();

            case PLAINS:
                return new BiomePlains();

            case DESERT:
                return new BiomeDesert();

            case FOREST:
                return new BiomeForest();

            case MOUNTAIN:
                return new BiomeMountain();

            default:
                return null;
        }
    }
}

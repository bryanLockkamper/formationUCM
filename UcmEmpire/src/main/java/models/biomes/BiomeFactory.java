package models.biomes;

public class BiomeFactory {

    public BiomeFactory() {

    }

    public IBiomes getBiome(BiomeType biomeType) {
        switch (biomeType) {
            case SEE:
                return new BiomeSee();

            case PLAIN:
                return new BiomePlain();

            case DESERT:
                return new BiomeDesert();

            case FOREST:
                return new BiomeForest();

            case MONTAIN:
                return new BiomeMontain();

            default:
                return null;
        }
    }
}

package models;

public class Case<T> {
    protected T content;
    protected Biome biome;
    protected boolean isWalk;
    protected boolean isBuild;

    public Case(T content) {
        this.content = content;
    }

    public Case(T content, Biome biome) {
        this.content = content;
        this.biome = biome;
        isBuild = true;
        isWalk = true;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Biome getBiome() {
        return biome;
    }

    public void setBiome(Biome biome) {
        this.biome = biome;
    }

    public boolean isWalk() {
        return isWalk;
    }

    public void setWalk(boolean walk) {
        isWalk = walk;
    }

    public boolean isBuild() {
        return isBuild;
    }

    public void setBuild(boolean build) {
        isBuild = build;
    }
}

package models;

public class Entity {
    protected int pv;
    protected String name;

    public Entity(int pv, String name) {
        this.pv = pv;
        this.name = name;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void suicide() {
    }
}

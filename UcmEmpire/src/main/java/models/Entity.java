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
        this.pv = Math.max(this.pv - pv, 0);
    }

    /**
     *
     * @param damage damage done on this unit
     * @return true if dead
     */
    public boolean takeDamage(int damage){
        setPv(getPv()-damage);
        return getPv() <= 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void suicide() {
        this.pv =0;
    }

}

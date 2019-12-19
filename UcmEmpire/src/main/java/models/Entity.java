package models;

public class Entity {
    protected int hp;
    protected String name;

    public Entity(int hp, String name) {
        this.hp = hp;
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(this.hp - hp, 0);
    }

    /**
     *
     * @param damage damage done on this unit
     * @return true if dead
     */
    public boolean takeDamage(int damage){
        setHp(getHp()-damage);
        return getHp() <= 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void suicide() {
        this.hp = 0;
    }

}

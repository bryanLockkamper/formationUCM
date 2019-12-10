package models;

public class Case<T> {
    protected T content;
    protected boolean isWalk;
    protected boolean isBuild;

    public Case(T content) {
        this.content = content;
        isBuild = true;
        isWalk = true;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
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

package com.ucm.ucmempire.controllers.pathfinding;


public class Node {
    private int g;
    private int h;
    private int f;
    private Position position;
    private boolean walkable;
    private Node parent;

    public Node()
    {
        walkable = true;
        g = h = f = 0;
        parent = this;
    }

    public Node(Position position) {
        this();
        this.position = position;
    }

    public Node(int x, int y) {
        this();
        this.position = new Position(x,y);
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}

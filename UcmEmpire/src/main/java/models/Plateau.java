package models;

import controllers.Pathfinding.Node;
import controllers.Pathfinding.Position;
import javafx.geometry.Pos;
import models.unite.Paysan;

import java.util.*;

public class Plateau {
    protected List<List<Case>> plateau;
    protected String name;

    public Plateau(List<List<Case>> plateau, String name) {
        this.plateau = plateau;
        this.name = name;
    }

    public Plateau(String name) {
        this.name = name;
        plateau = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            plateau.add(new ArrayList<>());
            for (int j = 0; j < 10; j++) {
                plateau.get(i).add(new Case((new Random().nextInt(5) == 0) ? new Paysan(100, "payon", 5) : " ", new Biome("plaine")));
            }
        }
    }

    public Plateau() {
        
    }

    public List<List<Case>> getPlateau() {
        return plateau;
    }

    public void setPlateau(List<List<Case>> plateau) {
        this.plateau = plateau;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void move(Case<Entity> first, Case<Entity> second) {
        HashMap<Map.Entry<Integer,Integer>, Node> l_node;
    }

    public void remove(Case<Entity> second) {
    }

    public void setCase(Case<Entity> second) {
    }
}

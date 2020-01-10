package controllers.pathfinding;

public class Node {
    int cout_g, cout_h, cout_f;

    Position position;   // 'adresse' du parent (qui sera toujours dans la map fermée)

    public Node() {

    }

    public Node(int x, int i) {
        position = new Position(x,i);
    }
}

package controllers.pathfinding;

import models.boardPackage.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AStarService {
    Map<Position, Node> openList, closedList;
    private Board board;
    private Position start, finish;

    public AStarService(Board board, Position start, Position finish) {
        this.board = board;
        this.start = start;
        this.finish = finish;
    }

    public Position run(int pa) {
        Position current = new Position();
        current.setX(start.getX());
        current.setY(start.getY());
        Node start_node = new Node();
        start_node.parent = start;
        openList.put(current, start_node);
        addClosedList(current);
        addCaseNearby(current);
        while (current.getX() != finish.getX() && current.getY() != finish.getY() && !openList.isEmpty()) {
            current = bestNode();
            addClosedList(current);
            addCaseNearby(current);
        }
        if (current.getX() == finish.getX() && current.getY() == finish.getY()) {
            return findPath().get(pa);
        } else {
            return start;
        }
    }

    private int distanceCalculation(Position p1, Position p2) {
        return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
    }

    private void addCaseNearby(Position position) {
        /* on met tous les noeuds adjacents dans la liste ouverte (+vérif) */
//        for (int i = position.getX() -1; i <= position.getX() +1 ; i++) {
//            if (i>=0 && i<getPlateau().size()){ // en dehors de l'image, on oublie
//                for (int j = position.getY()-1; j < position.getY() +1; j++) {
//                    if (j >= 0 && j < getPlateau().get(0).size() // Test si on est pas en dehors du plateau
//                            && !((i == position.getX()) && (j== position.getY())) /* case actuelle n, on oublie */
//                              && !() ){
//                    }
//                }
//            }
//        }
        Position position1 = new Position(position.getX() - 1, position.getY());
        if (isInsideBoundsAndWalkable(position1))
            addToList(position, position1);

        Position position2 = new Position(position.getX() + 1, position.getY());
        if (isInsideBoundsAndWalkable(position2))
            addToList(position, position2);

        Position position3 = new Position(position.getX(), position.getY() - 1);
        if (isInsideBoundsAndWalkable(position3))
            addToList(position, position3);

        Position position4 = new Position(position.getX(), position.getY() + 1);
        if (isInsideBoundsAndWalkable(position4))
            addToList(position, position4);
    }

    private boolean isInsideBoundsAndWalkable(Position p) {
        return (p.getX() >= 0 && p.getX() < board.getBoard().size() // verifier borne horizontale
                && p.getY() >= 0 && p.getY() < board.getBoard().get(0).size()) // verifier borne verticale
                && (board.getBoard().get(p.getX()).get(p.getY()).isWalkable()); // verifier  si marchable
    }

    private void addToList(Position actual, Position adj) {
        if (!closedList.containsKey(adj)) {
            /* le noeud n'est pas déjà présent dans la liste fermée */
            Node tmp = new Node();
            /* calcul du cout G du noeud en cours d'étude : cout du parent + distance jusqu'au parent */
            tmp.cout_g = closedList.get(actual).cout_g + distanceCalculation(adj, actual);

            /* calcul du cout H du noeud à la destination */
            tmp.cout_h = distanceCalculation(adj, actual);
            tmp.cout_f = tmp.cout_g + tmp.cout_h;
            tmp.parent = actual;

            if (openList.containsKey(adj)) {
                /* le noeud est déjà présent dans la liste ouverte, il faut comparer les couts */
                if (tmp.cout_f < openList.get(actual).cout_f)
                    /* si le nouveau chemin est meilleur, on met à jour */
                    openList.put(adj, tmp);

                /* le noeud courant a un moins bon chemin, on ne change rien */
            } else {
                /* le noeud n'est pas présent dans la liste ouverte, on l'y ajoute */
                openList.put(adj, tmp);
            }
        }
    }

    private Position bestNode() {
        List<Node> nodes = (List<Node>) openList.values();
        Node node = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++)
            if (nodes.get(1).cout_f < node.cout_f)
                node = nodes.get(i);
        Node finalNode = node;
        return (Position) openList.entrySet().stream().filter(positionNodeEntry -> finalNode.equals(positionNodeEntry.getValue())).map(Map.Entry::getKey);
    }

    private void addClosedList(Position position) {
        Node node = openList.get(position);
        closedList.put(position, node);
        openList.remove(position);
    }

    private List<Position> findPath() {
        List<Position> way = new ArrayList<>();
        Node tmp = closedList.get(finish);
        Position p = new Position();
        Position prec = new Position();
        p.setX(finish.getX());
        p.setY(finish.getY());
        prec.setX(tmp.parent.getX());
        prec.setY(tmp.parent.getY());
        way.add(p);

        while (prec.getX() != start.getX() && prec.getY() != start.getY()) {
            p.setX(prec.getX());
            p.setY(prec.getY());
            way.add(p);
            tmp = closedList.get(tmp.parent);
            prec.setX(tmp.parent.getX());
            prec.setY(tmp.parent.getY());
        }

        return way;
    }
}

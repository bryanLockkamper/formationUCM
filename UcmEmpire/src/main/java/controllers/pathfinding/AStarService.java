package controllers.pathfinding;

import com.sun.xml.internal.ws.addressing.EPRSDDocumentFilter;
import javafx.geometry.Pos;
import javafx.util.Pair;
import models.boardPackage.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AStarService {
    private List<Node> openList, closedList;
    private Board board;
    private Position start, finish;

    public AStarService(Board board, Position start, Position finish) {
        this.board = board;
        this.start = start;
        this.finish = finish;
        openList = new ArrayList<>();
        closedList = new ArrayList<>();
    }

    public Position run(int pa) {
        Position current = start;
        Node node = new Node();
        node.position = start;
        openList.add(node);
        addClosedList(node);
        addCaseNearby(node);
        while (!current.equals(finish) || !openList.isEmpty()) {
            node = bestNode();
            current = node.position;
            addClosedList(node);
            addCaseNearby(node);
        }

        if (current.equals(finish)) {
            return findPosition(pa);
        } else {
            return start;
        }
    }

    private int distanceCalculation(Position p1, Position p2) {
        return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
    }

    private void addCaseNearby(Node node) {
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
        Node node1 = new Node(node.position.getX() - 1, node.position.getY());
        if (isInsideBoundsAndWalkable(node1.position))
            addToList(node, node1);

        Node node2 = new Node(node.position.getX() + 1, node.position.getY());
        if (isInsideBoundsAndWalkable(node2.position))
            addToList(node, node2);

        Node node3 = new Node(node.position.getX(), node.position.getY() - 1);
        if (isInsideBoundsAndWalkable(node3.position))
            addToList(node, node3);

        Node node4 = new Node(node.position.getX(), node.position.getY() + 1);
        if (isInsideBoundsAndWalkable(node4.position))
            addToList(node, node4);
    }

    private boolean isInsideBoundsAndWalkable(Position p) {
        return (p.getX() >= 0 && p.getX() < board.getBoard().size() // verifier borne horizontale
                && p.getY() >= 0 && p.getY() < board.getBoard().get(0).size()) // verifier borne verticale
                && (board.getBoard().get(p.getX()).get(p.getY()).isWalkable()); // verifier  si marchable
    }

    private boolean isClosedList(Position position) {
        return closedList.stream().anyMatch(positionNodePair -> positionNodePair.position.equals(position));
    }

    private Node getClosedList(Position position) {
        return closedList.stream()
                .filter(positionNodePair -> positionNodePair.position.equals(position))
                .collect(Collectors.toList()).get(0);
    }

    private boolean isOpenList(Position position) {
        return openList.stream().anyMatch(positionNodePair -> positionNodePair.position.equals(position));
    }

    private Node getOpenList(Position position) {
        return closedList.stream()
                .filter(positionNodePair -> positionNodePair.position.equals(position))
                .collect(Collectors.toList())
                .get(0);
    }

    private void addToList(Node actual, Node adj) {
        if (!isClosedList(adj.position)) {
            /* le noeud n'est pas déjà présent dans la liste fermée */
            Node tmp = new Node();
            /* calcul du cout G du noeud en cours d'étude : cout du parent + distance jusqu'au parent */
            tmp.cout_g = getClosedList(actual.position).cout_g + distanceCalculation(adj.position, actual.position);

            /* calcul du cout H du noeud à la destination */
            tmp.cout_h = distanceCalculation(adj.position, finish);
            tmp.cout_f = tmp.cout_g + tmp.cout_h;
            tmp.position = adj.position;

            if (isOpenList(adj.position)) {
                /* le noeud est déjà présent dans la liste ouverte, il faut comparer les couts */
                if (tmp.cout_f < getOpenList(actual.position).cout_f)
                    /* si le nouveau chemin est meilleur, on met à jour */
                    openList.add(tmp);

                /* le noeud courant a un moins bon chemin, on ne change rien */
            } else {
                /* le noeud n'est pas présent dans la liste ouverte, on l'y ajoute */
                openList.add(tmp);
            }

        }
    }

    private Node bestNode() {
        Node node = openList.get(0);
        int i = 1;
        for (; i < openList.size(); i++)
            if (openList.get(1).cout_f < node.cout_f)
                node = openList.get(i);
        return node;
    }

    private void addClosedList(Node node) {
        closedList.add(node);
        openList.remove(node);
    }

    private Position findPosition(int pa) {
        closedList.forEach(node -> System.out.println(node.position));
        int size = closedList.size();
        if (pa >= size)
            return closedList.get(size - pa).position;
        else
            return closedList.get(size - 1).position;
    }

    private List<Position> findPath() {
        List<Position> way = new ArrayList<>();
        Node tmp = getClosedList(finish);
        Position p = new Position();
        Position prec = new Position();
        p.setX(finish.getX());
        p.setY(finish.getY());
        prec.setX(tmp.position.getX());
        prec.setY(tmp.position.getY());
        way.add(p);

        while (!prec.equals(start)) {
            p.setX(prec.getX());
            p.setY(prec.getY());
            way.add(p);
            tmp = getClosedList(tmp.position);
            prec.setX(tmp.position.getX());
            prec.setY(tmp.position.getY());
        }

        return way;
    }
}

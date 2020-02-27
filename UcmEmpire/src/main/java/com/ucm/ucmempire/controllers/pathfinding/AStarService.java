package com.ucm.ucmempire.controllers.pathfinding;

import com.ucm.ucmempire.models.boardPackage.Board;

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

    public PositionDTO run(int pa) {
        if (start.equals(finish))
            return new PositionDTO(start, 0);
        else {
            openList.add(new Node(start));
            Node current = new Node();
            current.setPosition(new Position(-1, -1));
            while (!current.getPosition().equals(finish) && !openList.isEmpty()) {
                current = bestNode();
                addClosedList(current);
                addCaseNearby(current);
            }

            if (current.getPosition().equals(finish) & pa > 0) {
                List<Position> positions = findPath();
                if (pa >= positions.size())
                    return new PositionDTO(positions.get(0), positions.size());
                else {
                    return new PositionDTO(positions.get(positions.size() - pa), pa);
                }
            } else {
                return new PositionDTO(start, 0);
            }
        }
    }

    private int distanceCalculation(Position p1, Position p2) {
        return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
    }

    private void addCaseNearby(Node node) {
        Node node1 = new Node(node.getPosition().getX() - 1, node.getPosition().getY());
        if (isInsideBoundsAndWalkable(node1.getPosition()))
            addToList(node, node1);

        Node node2 = new Node(node.getPosition().getX() + 1, node.getPosition().getY());
        if (isInsideBoundsAndWalkable(node2.getPosition()))
            addToList(node, node2);

        Node node3 = new Node(node.getPosition().getX(), node.getPosition().getY() - 1);
        if (isInsideBoundsAndWalkable(node3.getPosition()))
            addToList(node, node3);

        Node node4 = new Node(node.getPosition().getX(), node.getPosition().getY() + 1);
        if (isInsideBoundsAndWalkable(node4.getPosition()))
            addToList(node, node4);
    }

    private boolean isInsideBoundsAndWalkable(Position p) {
        return (p.getX() >= 0 && p.getX() < board.getBoard().size() // verifier borne horizontale
                && p.getY() >= 0 && p.getY() < board.getBoard().get(0).size()) // verifier borne verticale
                && board.getBoard().get(p.getX()).get(p.getY()).isWalkable() // verifier  si marchable
                && board.getBoard().get(p.getX()).get(p.getY()).getContent() == null; // Verifier si dispo
    }

    private boolean isClosedList(Position position) {
        return closedList.stream().anyMatch(positionNodePair -> positionNodePair.getPosition().equals(position));
    }

    private Node getClosedList(Position position) {
        return closedList.stream()
                .filter(positionNodePair -> positionNodePair.getPosition().equals(position))
                .collect(Collectors.toList()).get(0);
    }

    private boolean isOpenList(Position position) {
        return openList.stream().anyMatch(positionNodePair -> positionNodePair.getPosition().equals(position));
    }

    private Node getOpenList(Position position) {
        return closedList.stream()
                .filter(positionNodePair -> positionNodePair.getPosition().equals(position))
                .collect(Collectors.toList())
                .get(0);
    }

    private void addToList(Node actual, Node adj) {
        if (!isClosedList(adj.getPosition())) {
            /* le noeud n'est pas déjà présent dans la liste fermée */
            Node tmp = new Node();
            /* calcul du cout G du noeud en cours d'étude : cout du parent + distance jusqu'au parent */
            tmp.setG(getClosedList(actual.getPosition()).getG() + distanceCalculation(adj.getPosition(), actual.getPosition()));

            /* calcul du cout H du noeud à la destination */
            tmp.setH(distanceCalculation(adj.getPosition(), finish));
            tmp.setF(tmp.getG() + tmp.getH());
            tmp.setPosition(adj.getPosition());
            tmp.setParent(actual);

            if (isOpenList(adj.getPosition())) {
                /* le noeud est déjà présent dans la liste ouverte, il faut comparer les couts */
                if (tmp.getF() < getOpenList(actual.getPosition()).getF())
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
            if (openList.get(i).getF() < node.getF())
                node = openList.get(i);
        return node;
    }

    private void addClosedList(Node node) {
        closedList.add(node);
        openList.remove(node);
    }

    private List<Position> findPath() {
        List<Position> way = new ArrayList<>();
        Node node = closedList.get(closedList.size() - 1);
        while (!node.getPosition().equals(start)) {
            way.add(node.getPosition());
            node = node.getParent();
        }
        return way;
    }
}

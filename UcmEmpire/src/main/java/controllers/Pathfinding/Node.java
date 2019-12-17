package controllers.Pathfinding;

import java.util.Map;

public class Node {
    int cout_g, cout_h, cout_f;

    Position parent;   // 'adresse' du parent (qui sera toujours dans la map fermée)
}

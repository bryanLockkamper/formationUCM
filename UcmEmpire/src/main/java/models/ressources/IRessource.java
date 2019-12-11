package models.ressources;

public interface IRessource {
    int getRessource(RessourceName ressourceName);
    boolean addRessource(int nbRessourceAAjouter, RessourceName ressourceName);
}

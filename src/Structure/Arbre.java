package Structure;

import Modele.Grille;
public class Arbre 
{
    Noeud racine;
    Noeud courant;

    public Arbre(Grille g)
    {
        this.racine = new Noeud(g);
        this.courant = racine;
    }
}
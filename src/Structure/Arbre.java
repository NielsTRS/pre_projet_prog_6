package Structure;

import Modele.Grille;
public class Arbre 
{
    Noeud racine;
    public Noeud courant;

    public Arbre(Grille g)
    {
        this.racine = new Noeud(g);
        this.courant = racine;
    }

    public Noeud getRacince()
    {
        return this.racine;
    }

    public Noeud getCourant()
    {
        return this.courant;
    }

}
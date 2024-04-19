package Structure;

import java.util.ArrayList;
import Modele.Grille;

public class Noeud 
{
    Noeud parent;
    Grille configuration;
    ArrayList<Noeud> fils;

    public Noeud(Grille g)
    {
        this.parent = null;
        this.configuration = g;
        this.fils = new ArrayList<>();
    }

    public void ajouteFils(Grille g)
    {
        Noeud n = new Noeud(g);
        n.parent=this;
        this.fils.add(n);
    }

    public Noeud getParent()
    {
        return this.parent;
    }

    public Grille getConfig()
    {
        return this.configuration;
    }

    public ArrayList<Noeud> getFils()
    {
        return this.fils;
    }

    
}

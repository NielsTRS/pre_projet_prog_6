package Structure;

import java.util.ArrayList;

import Modele.Coup;
import Modele.Grille;

public class Noeud 
{
    Noeud parent;
    Grille configuration;
    Coup coup;
    ArrayList<Noeud> fils;

    public Noeud(Grille g)
    {
        this.parent = null;
        this.configuration = g;
        this.fils = new ArrayList<>();
        this.coup = null;
    }

    public Noeud(Grille g, Coup c)
    {
        this.parent = null;
        this.configuration = g;
        this.fils = new ArrayList<>();
        this.coup = new Coup(c.getX(), c.getY());
    }

    public void ajouteFils(Grille g, Coup c)
    {
        Noeud n = new Noeud(g, c);
        n.parent=this;
        this.fils.add(n);
    }

    public Noeud getParent()
    {
        return this.parent;
    }

    public Coup getCoup()
    {
        return this.coup;
    }

    public Grille getConfig()
    {
        return this.configuration;
    }

    public ArrayList<Noeud> getFils()
    {
        return this.fils;
    }

    public boolean configurationPerdante()
    {
        return this.configuration.getCase(0, 0).getEstMange();
    }

    public boolean estFeuille()
    {
        return this.fils.isEmpty();
    }
}

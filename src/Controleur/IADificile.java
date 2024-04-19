package Controleur;
import java.util.ArrayList;
import java.util.Random;

import Modele.Case;
import Structure.Arbre;
import Structure.Noeud;

public class IADificile extends IA
{
    Random r;
    private Arbre config;
    private ArrayList<Noeud> coupsJouable;

    IADificile(Jeu j)
    {
        r = new Random();
        this.grille = j.getGrille();
        initConfig();
    }

    Arbre initConfig()
    {
        config = new Arbre(this.grille);
        //TODO remplir l arbre de configurations(chaque noeud etant un clone de la grille a un etat de la partie)
        return null;
    }

    boolean arbreEt(Noeud n)
    {
        if (n.estFeuille())
        {
            return !n.configurationPerdante();
        }
        boolean retour = true;
        for(Noeud c : n.getFils())
        {
            retour = retour && arbreOu(c);
            if(!retour)
            {
                if(c.getParent()==config.getCourant()) //on garde les coups gagnants a partir de la position initiale
                {
                    this.coupsJouable.add(c);
                }
            }
        }
        return retour;
    }

    boolean arbreOu(Noeud n)
    {
        if (n.estFeuille())
        {
            return !n.configurationPerdante();
        }
        boolean retour = false;
        for(Noeud c : n.getFils())
        {
            retour = retour || arbreEt(c);
            if(retour)
            {
                if(c.getParent()==config.getCourant())
                {
                    this.coupsJouable.add(c);
                }
            }
        }
        return retour;
    }
    
    Case estimeCoup()
    {
        this.coupsJouable = new ArrayList<>();
        arbreOu(config.getCourant());
        if(coupsJouable.isEmpty())  // il n y a pas de coups gagants
        {
            //on joue un coup au hasard parmis les coups jouables
            int i = r.nextInt(config.getCourant().getFils().size());

            //mise a jour du courant
            this.config.courant = config.getCourant().getFils().get(i);


            int caseX = config.getCourant().getCoup().getX();
            int caseY = config.getCourant().getCoup().getY();
            return this.grille.getCase(caseX, caseY);
        }
        else //il y a au moins 1 coup gagnant
        {
            //on joue un coup au hasard parmis les coups jouables
            int i = r.nextInt(coupsJouable.size());

            //mise a jour du courant
            this.config.courant = this.coupsJouable.get(i);


            int caseX = this.coupsJouable.get(i).getCoup().getX();
            int caseY = this.coupsJouable.get(i).getCoup().getY();
            return this.grille.getCase(caseX, caseY);
        }
    }

    boolean trouveCourant()
    {
        boolean trouve = false;
        if(this.grille == this.config.getCourant().getConfig())
        {
            //cas initial ou l IA est le J1
            return true;
        }
        else
        {
            int i=0;
            while(!trouve && i<this.config.getCourant().getFils().size())
            {
                
                if(this.grille == this.config.getCourant().getFils().get(i).getConfig())
                {
                    //on se deplace dans l arbre sur le coup joue par l autre joueur.
                    this.config.courant = this.config.getCourant().getFils().get(i);
                    trouve = true;
                }
            }
            return trouve;
        }
    }

    @Override
	void joue() 
    {
        if(trouveCourant())
        {
            Case c = estimeCoup();
            this.grille.mange(c.getX(), c.getY());
        }
        else
        {
            System.out.println("la configuration actuelle n'est pas trouvee");
        }
    }


}

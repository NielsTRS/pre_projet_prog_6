package Controleur;
import Structure.Arbre;

public class IADificile extends IA
{
    private Arbre config;

    IADificile()
    {
        initConfig();
    }

    Arbre initConfig()
    {
        config = new Arbre(this.grille);
        //AFAIRE remplit l arbre de configurations(chaque noeud etant un clone de la grille a un etat de la partie)
        return null;
    }
    


}

package Controleur;

import java.util.Random;


public class IAAleatoire extends IA
{
    Random r;
    public IAAleatoire()
    {
        r = new Random();
    }

    @Override
	void joue() 
    {
        int x;
        int y;
        do
        {
            x = r.nextInt(this.grille.getColonnes());
            y = r.nextInt(this.grille.getLignes());
        }
        while(this.grille.getCase(x,y).getEstMange());
        grille.mange(x,y);
    }
}

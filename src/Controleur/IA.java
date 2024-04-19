package Controleur;

import Modele.Grille;

public abstract class IA
{
    Grille grille;

    public static IA nouvelle(Jeu j, String ia) 
	{
		IA resultat = null;
		switch (ia) {
			case "Aleatoire":
				resultat = new IAAleatoire();
				break;
			case "dificile":
				resultat = new IADificile();
				break;
			default:
				System.out.println("IA de type " + ia + " non supportée");
		}
		return resultat;
	}

    public final void simuleCoups() {
		//grille= grille.clone();
		joue();
	}

	void joue() 
	{

	}
}

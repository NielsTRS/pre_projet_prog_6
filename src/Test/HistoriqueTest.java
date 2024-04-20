package Test;

import org.junit.Test;
import Modele.Grille;
import Modele.Historique;
import Modele.Coup;
import static org.junit.Assert.*;

public class HistoriqueTest {
    @Test
    public void testHistorique() {
        Grille grille = new Grille(6, 7);
        Historique historique = new Historique();

        // Effectuer des actions

        grille.mange(2, 2);
        historique.ajouterCoup(new Coup(2, 2));

        grille.mange(3, 3);
        historique.ajouterCoup(new Coup(3, 3));

        // Vérifier l'état de la grille
        assertTrue(grille.getCase(3, 3).getEstMange());
        assertTrue(grille.getCase(2, 2).getEstMange());

        System.out.println(historique);

        // Annuler une action
        Coup coup = historique.annulerCoup();
        System.out.println(historique);
        if(coup != null){
            grille.annuler(coup.getX(), coup.getY());
        }

        // Vérifier l'état de la grille
        assertTrue(grille.getCase(2, 2).getEstMange());

        for(int j = 3; j < grille.getLignes(); j++){
            for(int i = 3; i < grille.getColonnes(); i++){
                assertFalse(grille.getCase(i, j).getEstMange());
            }
        }
    }

    @Test
    public void testHistoriqueCasParticulier() {
        Grille grille = new Grille(6, 7);
        Historique historique = new Historique();

        // Effectuer des actions

        grille.mange(0, 0);
        historique.ajouterCoup(new Coup(0, 0));

        // Vérifier l'état de la grille
        for(int j = 0; j < grille.getLignes(); j++){
            for(int i = 0; i < grille.getColonnes(); i++){
                assertTrue(grille.getCase(i, j).getEstMange());
            }
        }

        System.out.println(historique);

        // Annuler une action
        Coup coup = historique.annulerCoup();
        System.out.println(historique);
        if(coup != null){
            grille.annuler(coup.getX(), coup.getY());
        }

        // Vérifier l'état de la grille
        assertTrue(grille.getCase(0, 0).getEstPoisson());

        for(int j = 0; j < grille.getLignes(); j++){
            for(int i = 0; i < grille.getColonnes(); i++){
                assertFalse(grille.getCase(i, j).getEstMange());
            }
        }
    }
}
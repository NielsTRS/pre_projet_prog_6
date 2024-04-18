package Vue;

import Modele.Case;
import Modele.Grille;

import java.awt.*;

public class ZoneGauffre {
    Image gauffreEmpoisonne = Affichage.charge("res/Images/gauffre_empoisonne.png");
    Image gauffreNormal = Affichage.charge("res/Images/gauffre.png");
    private Grille grille;

    public ZoneGauffre(Grille grille) {
        this.grille = grille;
    }

    public void paintGauffre(Graphics g, int largeurGauffre, int hauteurGauffre) {
        int largeurCase = largeurGauffre / grille.getColonnes();
        int hauteurCase = hauteurGauffre / grille.getLignes();

        if (grille.getFin()) {
            g.drawString("Fin de la partie", largeurGauffre / 2, hauteurGauffre / 2);
        } else{
            for (Case c : grille.getCases()) {
                if (c.getEstMange()) {
                    continue; // Passe à l'itération suivante si la case est déjà mangée
                }

                if (c.getEstPoisson()) {
                    g.drawImage(gauffreEmpoisonne, c.getX() * largeurCase, c.getY() * hauteurCase, largeurCase, hauteurCase, null);
                } else {
                    g.drawImage(gauffreNormal, c.getX() * largeurCase, c.getY() * hauteurCase, largeurCase, hauteurCase, null);
                }
            }
        }
    }
}

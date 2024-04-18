package Vue;

import Modele.Case;
import Modele.Grille;

import java.awt.*;

public class ZoneGauffre {
    Image gauffreEmpoisonne = Affichage.charge("res/Images/gauffre_empoisonne.png");
    Image gauffreNormal = Affichage.charge("res/Images/gauffre.png");
    private Grille grille;
    private int largeurGauffre;
    private int hauteurGauffre;

    public ZoneGauffre(Grille grille) {
        this.grille = grille;
    }

    public void paintGauffre(Graphics g) {
        int largeurCase = this.largeurGauffre / grille.getColonnes();
        int hauteurCase = this.hauteurGauffre / grille.getLignes();

        if (grille.getFin()) {
            g.drawString("Fin de la partie", this.largeurGauffre / 2, this.hauteurGauffre / 2);
        } else {
            for (Case c : grille.getCases()) {
                if (!c.getEstMange()) {
                    if (c.getEstPoisson()) {
                        g.drawImage(gauffreEmpoisonne, c.getX() * largeurCase, c.getY() * hauteurCase, largeurCase, hauteurCase, null);
                    } else {
                        g.drawImage(gauffreNormal, c.getX() * largeurCase, c.getY() * hauteurCase, largeurCase, hauteurCase, null);
                    }
                }
            }
        }
    }

    public void setLargeurGauffre(int largeurGauffre) {
        this.largeurGauffre = largeurGauffre;
    }

    public void setHauteurGauffre(int hauteurGauffre) {
        this.hauteurGauffre = hauteurGauffre;
    }

    public int getLargeurGauffre() {
        return largeurGauffre;
    }

    public int getHauteurGauffre() {
        return hauteurGauffre;
    }
}

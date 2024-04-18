package Vue;

import Modele.Case;
import Modele.Grille;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;


public class ZoneGauffre {
    Image gauffreEmpoisonne = charge("res/Images/gauffre_empoisonne.png");
    Image gauffreNormal = charge("res/Images/gauffre.png");
    int largeurGauffre;
    int hauteurGauffre;
    int largeurCase;
    int hauteurCase;
    private Grille grille;

    public ZoneGauffre(Grille grille) {
        this.grille = grille;
    }


    public void paintGauffre(Graphics g, int largeurFenetre, int hauteurFenetre){
        largeurGauffre = largeurFenetre - largeurFenetre/3;
        largeurCase = largeurGauffre / grille.getColonnes();
        hauteurCase = hauteurGauffre / grille.getLignes();
        hauteurGauffre = hauteurFenetre;

        for (Case c : grille.getCases()) {
            if(c.getEstMange()) {
                continue; // Passe à l'itération suivante si la case est déjà mangée
            }

            if(c.getEstPoisson()) {
                g.drawImage(gauffreEmpoisonne, c.getX()*largeurCase, c.getY()*hauteurCase, largeurCase, hauteurCase, null);
            } else {
                g.drawImage(gauffreNormal, c.getX()*largeurCase, c.getY()*hauteurCase, largeurCase, hauteurCase, null);
            }
        }
    }

    public Image charge(String nom) {
        try {
            return ImageIO.read(new FileInputStream(nom));
        } catch (Exception e) {
            System.err.println("Impossible de charger l'image " + nom);
            System.exit(1);
            return null;
        }
    }

    public int getHauteurGrille(){
        return hauteurGauffre;
    }
    public int getLargeurGrille(){
        return largeurGauffre;
    }

    public int getHauteurCase() {
        return hauteurCase;
    }

    public int getLargeurCase() {
        return largeurCase;
    }
}

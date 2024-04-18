package Vue;

import Modele.Case;
import Modele.Grille;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;


public class Affichage extends JComponent {
    Image gauffreEmpoisonne = charge("res/Images/gauffre_empoisonne.png");
    Image gauffreNormal = charge("res/Images/gauffre.png");
    private Grille grille;

    //TODO : faire classe zone avec les tailles des zones
    int largeurCase;
    int hauteurCase;
    int largeurFenetre;
    int hauteurFenetre;
    int largeurGauffre;
    int hauteurGauffre;

    public Affichage(Grille grille) {
        this.grille = grille;
    }

    private void paintGauffre(Graphics g){
        largeurCase = largeurGauffre / grille.getColonnes();
        hauteurCase = hauteurGauffre / grille.getLignes();

        //TODO: faire condition de fin de partie
        /*if(false){
            g.drawString("Fin de la partie", getWidth() / 2, getHeight() / 2);
        } else {*/
        for (Case c : grille.getCases()) {
            if(c.getEstMange()) {
                continue; // Passe à l'itération suivante si la case est déjà mangée
            }

            if(c.getEstPoisson()) {
                g.drawImage(gauffreEmpoisonne, c.getX()*largeurCase, c.getY()*hauteurCase, largeurCase, hauteurCase, null);
            } else {
                g.drawImage(gauffreNormal, c.getX()*largeurCase, c.getY()*hauteurCase, largeurCase, hauteurCase, null);
            }
            // TODO : changer en var de case dans
        }
        //}
    }

    @Override
    protected void paintComponent(Graphics g) {
        largeurFenetre = getSize().width;
        largeurGauffre = largeurFenetre - largeurFenetre/3;
        hauteurFenetre = getSize().height;
        hauteurGauffre = hauteurFenetre;
        paintGauffre(g);

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

    int getHauteurGrille(){
        return hauteurGauffre;
    }
    int getLargeurGrille(){
        return largeurGauffre;
    }

    int getHauteurCase() {
        return hauteurCase;
    }

    int getLargeurCase() {
        return largeurCase;
    }

}

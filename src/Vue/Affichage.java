package Vue;

import Modele.Caisse;
import Modele.Case;
import Modele.Grille;
import Modele.Niveau;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;

public class Affichage extends JComponent {
    Image gauffreEmpoisonne = charge("res/Images/gauffre_empoisonne.png");
    Image gauffreNormal = charge("res/Images/gauffre.png");
    private Grille grille;
    int largeurCase;
    int hauteurCase;

    public Affichage(Grille grille) {
        this.grille = grille;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int largeur = getSize().width;
        int hauteur = getSize().height;
        largeurCase = largeur / grille.getColonnes();
        hauteurCase = hauteur / grille.getLignes();

        //TODO: faire condition de fin de partie
        if(false){
            g.drawString("Fin de la partie", getWidth() / 2, getHeight() / 2);
        } else {
            for (Case c : grille.getCases()) {
                switch (c.getEtat()){
                    //TODO : changer en var de case dans
                    case 0:
                        g.drawImage(gauffreNormal, c.getX(), c.getY(), largeurCase, hauteurCase, null);
                        break;
                    case 1:
                        break;
                    case 2:
                        g.drawImage(gauffreNormal, c.getX(), c.getY(), largeurCase, hauteurCase, null);

                }

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

    int getHauteurCase() {
        return hauteurCase;
    }

    int getLargeurCase() {
        return largeurCase;
    }

}

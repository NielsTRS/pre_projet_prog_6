package Vue;

import Modele.Case;
import Modele.Grille;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;


public class Affichage extends JComponent {
    private ZoneGauffre zoneGauffre;

    int largeurFenetre;
    int hauteurFenetre;
    int largeurGauffre;
    int hauteurGauffre;

    public static Image charge(String nom) {
        try {
            return ImageIO.read(new FileInputStream(nom));
        } catch (Exception e) {
            System.err.println("Impossible de charger l'image " + nom);
            System.exit(1);
            return null;
        }
    }

    public Affichage(Grille grille) {
        this.zoneGauffre = new ZoneGauffre(grille);
    }

    @Override
    protected void paintComponent(Graphics g) {
        largeurFenetre = getSize().width;
        largeurGauffre = largeurFenetre - largeurFenetre / 3;
        hauteurFenetre = getSize().height;
        hauteurGauffre = hauteurFenetre;
        this.zoneGauffre.paintGauffre(g, largeurGauffre, hauteurGauffre);
    }

    public int getHauteurGrille() {
        return hauteurGauffre;
    }

    public int getLargeurGrille() {
        return largeurGauffre;
    }
}

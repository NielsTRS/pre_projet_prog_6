package Vue;

import Modele.Case;
import Modele.Grille;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;


public class Affichage extends JComponent {

    private Grille grille;
    private ZoneGauffre gauffre;

    //TODO : faire classe zone avec les tailles des zones

    int largeurFenetre;
    int hauteurFenetre;
    public Affichage(Grille grille) {
        this.gauffre = new ZoneGauffre(grille);
    }

    @Override
    protected void paintComponent(Graphics g) {
        largeurFenetre = getSize().width;

        hauteurFenetre = getSize().height;

        gauffre.paintGauffre(g, largeurFenetre, hauteurFenetre);

    }


}

package Vue;

import Modele.Grille;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;


public class Affichage extends JComponent {
    private ZoneGauffre zoneGauffre;

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
        this.zoneGauffre.setTaille(getSize().width - getSize().width / 3, getSize().height);
        this.zoneGauffre.paintGauffre(g);
    }

    public ZoneGauffre getZoneGauffre() {
        return zoneGauffre;
    }
}

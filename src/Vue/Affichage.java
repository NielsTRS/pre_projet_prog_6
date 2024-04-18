package Vue;

import Modele.Caisse;
import Modele.Niveau;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;

public class Affichage extends JComponent {
    Image imagePousseur = charge("res/Images/Pousseur.png");
    Image imageCaisse = charge("res/Images/Caisse.png");
    private Niveau niveau;

    public Affichage(Niveau niveau) {
        this.niveau = niveau;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(niveau.collision()){
            g.drawString("Fin de la partie", getWidth() / 2, getHeight() / 2);
        } else {
            g.drawImage(imagePousseur, niveau.getPersonnage().getX(), niveau.getPersonnage().getY(), null);
            for (Caisse caisse : niveau.getCaisses()) {
                g.drawImage(imageCaisse, caisse.getX(), caisse.getY(), null);
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
}

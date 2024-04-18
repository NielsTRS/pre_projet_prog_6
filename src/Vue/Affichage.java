package Vue;

import Modele.Caisse;
import Modele.Niveau;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Affichage extends JComponent {
    Image imagePousseur = ImageIO.read(new FileInputStream("res/Images/Pousseur.png"));
    Image imageCaisse = ImageIO.read(new FileInputStream("res/Images/Caisse.png"));
    private Niveau niveau;

    public Affichage(Niveau niveau) throws IOException {
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
}

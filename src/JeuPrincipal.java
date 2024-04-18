import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import Controller.Examen;
import Modele.Niveau;
import Vue.Affichage;

public class JeuPrincipal implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new JeuPrincipal());
    }

    // je n'arrive pas à utiliser cette méthode pour charger les images
    static Image charge(String nom) {
        try {
            ClassLoader cl = ClassLoader.getSystemClassLoader();
            return ImageIO.read(cl.getResourceAsStream(nom));
        } catch (Exception e) {
            System.err.println("Erreur imprévue");
            System.exit(1);
            return null;
        }
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Exam PROG6");
        Examen.start(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
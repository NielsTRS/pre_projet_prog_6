package Controleur;

import Modele.Grille;
import Modele.Case;
import Vue.Affichage;
import Vue.ZoneGauffre;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Jeu extends MouseAdapter {
    private Grille grille;
    private Affichage affichage;
    private ZoneGauffre gauffre;

    public static void start(JFrame frame) {
        Grille grille = new Grille(6,7); // A MODIFIER
        Affichage affichage = new Affichage(grille);
        ZoneGauffre gauffre = new ZoneGauffre(grille);
        Jeu j = new Jeu(grille, affichage, gauffre);
        frame.add(affichage);
        affichage.addMouseListener(j);
    }

    public Jeu(Grille grille, Affichage affichage, ZoneGauffre gauffre) {
        this.grille = grille;
        this.affichage = affichage;
        this.gauffre = gauffre;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Cordonnées du clic
        int x = e.getX();
        int y = e.getY();

        if (x < gauffre.getLargeurGrille()) {

            // Taille d'une cellule
            int cellWidth = gauffre.getLargeurGrille() / grille.getColonnes();
            int cellHeight = gauffre.getHauteurGrille() / grille.getLignes();

            // Cordonnées de la case
            x = x / cellWidth;
            y = y / cellHeight;

            System.out.println("Clic en (" + x + ", " + y + ")");

            grille.mange(x, y);
            affichage.repaint();
        }
    }
}

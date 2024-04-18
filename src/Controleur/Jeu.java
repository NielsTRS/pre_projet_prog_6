package Controleur;

import Modele.Grille;
import Modele.Case;
import Vue.Affichage;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Jeu extends MouseAdapter {
    private Grille grille;
    private Affichage affichage;

    public static void start(JFrame frame) {
        Grille grille = new Grille(6, 7); // A MODIFIER
        Affichage affichage = new Affichage(grille);
        Jeu j = new Jeu(grille, affichage);
        frame.add(affichage);
        affichage.addMouseListener(j);
    }

    public Jeu(Grille grille, Affichage affichage) {
        this.grille = grille;
        this.affichage = affichage;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Cordonnées du clic
        int x = e.getX();
        int y = e.getY();

        if (x < affichage.getZoneGauffre().getTaille()) {

            // Taille d'une cellule
            int cellWidth = affichage.getZoneGauffre().getTaille() / grille.getColonnes();
            int cellHeight = affichage.getZoneGauffre().getTaille() / grille.getLignes();

            // Cordonnées de la case
            x = x / cellWidth;
            y = y / cellHeight;

            System.out.println("Clic en (" + x + ", " + y + ")");

            grille.mange(x, y);
            affichage.repaint();
        }
    }
}

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
        Grille grille = new Grille(6,7); // A MODIFIER
        Affichage affichage = new Affichage(grille);
        Jeu examen = new Jeu(grille, affichage);
        frame.add(affichage);
        frame.addMouseListener(examen);
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

        // Cordonnées de la case
        x = x / (affichage.getSize().width * grille.getColonnes());
        y = y / (affichage.getSize().height * grille.getLignes());

        Case c = grille.getCase(x, y);

        if (!c.getEstMange()) {
            grille.mange(x, y);
            affichage.repaint();
        }
    }
}

package Vue;

import Modele.Case;
import Modele.Grille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZoneBouton {
    public ZoneBouton(JFrame frame) {
        JButton button1 = new JButton("annuler");
        JButton button2 = new JButton("refaire");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton a été cliqué !");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton 2 a été cliqué !");
            }
        });

        // Créer une boîte verticale pour le bouton
        Box boiteTexte = Box.createVerticalBox();
        boiteTexte.add(button1);
        boiteTexte.add(button2);

        // Ajouter les composants à la frame
        frame.add(boiteTexte, BorderLayout.EAST);

    }

    public JPanel createButtonPanel() {
        // Créer un JPanel pour contenir les boutons
        JPanel panel = new JPanel();

        // Utiliser un layout pour organiser les boutons
        panel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Exemple de FlowLayout

        // Créer les boutons
        JButton button1 = new JButton("Cliquezazerfaz ici");
        JButton button2 = new JButton("Cliquefqsdfqs ici");

        // Ajouter des action listeners aux boutons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton a été cliqué !");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton 2 a été cliqué !");
            }
        });

        // Ajouter les boutons au panel
        panel.add(button1);
        panel.add(button2);

        // Retourner le panel contenant les boutons
        return panel;
    }

    public void paintBouton(JFrame frame) {

    }



}

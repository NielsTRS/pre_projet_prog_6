package Controller;

import Modele.Niveau;
import Vue.Affichage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Examen extends KeyAdapter implements ActionListener {
    private Niveau niveau;
    private Timer timer;
    private Affichage affichage;

    public static void start(JFrame frame) {
        Niveau niveau = new Niveau();
        Affichage affichage;
        try {
            affichage = new Affichage(niveau);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Examen examen = new Examen(niveau, affichage);
        frame.add(affichage);
        frame.addKeyListener(examen);
    }

    public Examen(Niveau niveau, Affichage affichage) {
        this.niveau = niveau;
        this.affichage = affichage;
        this.timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        niveau.update();
        if (niveau.collision()) {
            timer.stop();
        }
        affichage.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                niveau.getPersonnage().deplacerGauche();
                break;
            case KeyEvent.VK_RIGHT:
                niveau.getPersonnage().deplacerDroit();
                break;
        }
        affichage.repaint();
    }
}

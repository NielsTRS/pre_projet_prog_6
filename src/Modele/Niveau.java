package Modele;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Niveau implements ActionListener {
    private Personnage personnage;
    private ArrayList<Caisse> caisses;
    private Timer timer;

    public Niveau() {
        this.personnage = new Personnage();
        this.caisses = new ArrayList<>();
        this.timer = new Timer(3000, this);
        this.timer.start();
    }

    public void ajouterCaisse() {
        caisses.add(new Caisse());
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public void update() {
        Iterator<Caisse> iterator = caisses.iterator();
        while (iterator.hasNext()) {
            Caisse caisse = iterator.next();
            caisse.deplace();
            if (caisse.getY() > 500) {
                iterator.remove();
            }
        }
    }

    public boolean collision() {
        for (Caisse caisse : caisses) {
            if (personnage.collision(caisse)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Caisse> getCaisses() {
        return caisses;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ajouterCaisse();
    }
}

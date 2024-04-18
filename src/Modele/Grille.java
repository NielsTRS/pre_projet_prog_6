package Modele;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Niveau {
    private ArrayList<Case> cases;
    private int lignes;
    private int colonnes;

    public Niveau(int lignes, int colonnes) {
        this.ajouterCases();
        this.lignes = lignes;
        this.colonnes = colonnes;
    }

    public void ajouterCases() {
        this.cases = new ArrayList<>();
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                Case case = new Case(i, j);
                if (i == 0 && j == 0) {
                    case.empoisonerCase();
                }
                this.cases.add(case);
            }
        }
    }

    public void mangerCase(Case case) {
        case.mangerCase();
    }

    public int getLignes() {
        return this.lignes;
    }

    public int getColonnes() {
        return this.colonnes;
    }

    public Case getCase(int i, int j) {
        return cases[j * colonnes + i];
    }
}

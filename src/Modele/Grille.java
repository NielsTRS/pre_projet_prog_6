package Modele;

import java.util.ArrayList;

public class Grille {
    private ArrayList<Case> cases;
    private int lignes;
    private int colonnes;

    public Grille(int lignes, int colonnes) {
        this.ajouterCases();
        this.lignes = lignes;
        this.colonnes = colonnes;
    }

    public void ajouterCases() {
        this.cases = new ArrayList<>();
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                Case c = new Case(i, j);
                if (i == 0 && j == 0) {
                    c.empoisonerCase();
                }
                this.cases.add(c);
            }
        }
    }

    public void mangerCase(Case c) {
        c.mangerCase();
    }

    public int getLignes() {
        return this.lignes;
    }

    public int getColonnes() {
        return this.colonnes;
    }

    public Case getCase(int i, int j) {
        return this.cases.get(j * colonnes + i);
    }
}

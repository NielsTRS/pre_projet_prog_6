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
        for (int j = 0; j < lignes; j++) {
            for (int i = 0; i < colonnes; i++) {
                Case c = new Case(i, j);
                if (i == 0 && j == 0) {
                    c.empoisonerCase();
                }
                this.cases.add(c);
            }
        }
    }

    public void mange(int x, int y) {
        
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

    public Case getCase(int x, int y) {
        return this.cases.get(y * colonnes + x);
    }

    public ArrayList<Case> getCases() {
        return this.cases;
    }
}

package Modele;

public class Personnage {
    private int x;
    private int y;
    public static final int LARGEUR = 128;
    public static final int HAUTEUR = 128;

    public Personnage() {
        this.x = 0;
        this.y = 450;
    }

    public void deplacerGauche() {
        if (x > 0) {
            x -= 50;
        }
    }

    public void deplacerDroit() {
        if (x < 500) {
            x += 50;
        }
    }

    public boolean collision(Caisse caisse) {
        return x < caisse.getX() + Caisse.LARGEUR &&
                x + LARGEUR > caisse.getX() &&
                y < caisse.getY() + Caisse.HAUTEUR &&
                y + HAUTEUR > caisse.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

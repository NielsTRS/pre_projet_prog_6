package Modele;

import java.util.Random;

public class Caisse {
    private int x;
    private int y;
    private static final Random random = new Random();
    public static final int LARGEUR = 128;
    public static final int HAUTEUR = 128;

    public Caisse() {
        this.x = random.nextInt(500);
        this.y = 0;
    }

    public void deplace() {
        y += 60;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

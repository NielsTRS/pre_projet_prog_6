package Modele;

public class Case {
    final private int x;
    final private int y;
    private int etat; //0 = pas manger, 1 = mange, 2 = poison
    public static final int PASMANGE = 0;
    public static final int MANGE = 1;
    public static final int POISON = 2;


    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.etat = PASMANGE;
    }

    public void mangerCase(){
        if (etat == PASMANGE){
            etat = MANGE;
        }
        else {
            System.out.println("case deja mangee :" + x + y);
        }
    }

    public void empoisonerCase(){
        this.etat = POISON;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getEtat(){return etat;}


}

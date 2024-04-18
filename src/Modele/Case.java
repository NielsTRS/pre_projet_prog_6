package Modele;

public class Case {
    final private int x;
    final private int y;
    private int etat; //0 = pas manger, 1 = mange, 2 = poison
    static final int PASMANGER = 0;
    static final int MANGER = 1;
    static final int POISON = 2;


    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.etat = PASMANGER;
    }

    public void mangerCase(){
        if (etat == PASMANGER){
            etat = MANGER;
        }
        else {
            System.out.println("casse deja mange :" + x + y);
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

package Modele;


import java.util.Stack;

public class Historique {

    private Stack<Coup> coups;

    public Historique() {
        this.coups = new Stack<>();
    }

    public void ajouterCoup(Coup action) {
        coups.push(action);
    }

    public Coup annulerCoup() {
        if (!coups.isEmpty()) {
            return coups.pop();
        }
        return null;
    }

    @Override
    public String toString() {
        String message = "Historique{";
        for (Coup coup : coups) {
            message += "coups= x:" + coup.getX() + " y:" + coup.getY() + "; ";
        }
        message += "}";
        return message;
    }

}

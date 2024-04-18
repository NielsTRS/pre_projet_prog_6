import javax.swing.*;

import Controleur.Jeu;

public class JeuPrincipal implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new JeuPrincipal());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Exam PROG6");
        Jeu.start(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
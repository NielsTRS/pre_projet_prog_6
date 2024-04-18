package Test;

import Modele.Niveau;
import Vue.Affichage;
import org.junit.Test;
import java.awt.Image;
import static org.junit.Assert.*;

public class AffichageTest {

    @Test
    public void testCharge() {
        Affichage affichage = new Affichage(new Niveau());
        Image image = affichage.charge("res/Images/gauffre.png");
        assertNotNull("L'image ne doit pas être null", image);
    }

    // Ajoutez d'autres méthodes de test ici
}
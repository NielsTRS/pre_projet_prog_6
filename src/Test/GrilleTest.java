package Test;

import Modele.Case;
import Modele.Grille;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GrilleTest {
    @Test
    public void testGrille(){
        Grille g = new Grille(5, 5);
        Case c = g.getCase(0, 0);
        assertNotNull(c);
        assert g.getLignes() == 5 && g.getColonnes() == 5;
        assertTrue(c.getEstPoisson());
        g.mangerCase(c);
        assertTrue(c.getEstMange());
    }

    @Test
    public void testXY() {
        Grille g = new Grille(3, 5);
        for (int j = 0; j < g.getLignes(); j++) {
            for (int i = 0; i < g.getColonnes(); i++) {
                Case c = g.getCase(i, j);
                assertEquals("La case n'est pas à la bonne position", i, c.getX());
                assertEquals("La case n'est pas à la bonne position", j, c.getY());
            }
        }
    }
}

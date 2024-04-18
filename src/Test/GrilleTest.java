package Test;

import Modele.Case;
import Modele.Grille;
import org.junit.Test;

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
}

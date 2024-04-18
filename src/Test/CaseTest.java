package Test;

import Modele.Case;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class CaseTest {
    @Test
    public void testXY() {
        Case c = new Case(0, 0);
        assert c.getX() == 0 && c.getY() == 0;
    }

    @Test
    public void testEtat() {
        Case c = new Case(0, 0);
        assertFalse(c.getEstMange());
        assertFalse(c.getEstPoisson());
        c.empoisonnerCase();
        assertTrue(c.getEstPoisson());
        c.mangerCase();
        assertTrue(c.getEstMange());
    }
}

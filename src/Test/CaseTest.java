package Test;

import Modele.Case;

import org.junit.Test;

public class CaseTest {
    @Test
    public void testXY() {
        Case c = new Case(0, 0);
        assert c.getX() == 0 && c.getY() == 0;
    }

    @Test
    public void testEtat() {
        Case c = new Case(0, 0);
        assert c.getEtat() == 0;
        c.empoisonerCase();
        assert c.getEtat() == Case.POISON;
        c.mangerCase();
        assert c.getEtat() == Case.MANGE;
    }
}

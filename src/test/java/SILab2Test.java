import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    public void test1() {
        List<Item> t=new ArrayList<Item>(1);
        Item i = new Item("supa", "0", 301, 0.9F);
        t.add(i);
        assertEquals(SILab2.checkCart(t,241), true);

        t.clear();
        i = new Item("supa", "0", 301, 0);
        t.add(i);
        assertEquals(SILab2.checkCart(t, 300), false);

        t.clear();
        i = new Item(null, "a", 0, 0);
        t.add(i);
        Exception e = assertThrows(Exception.class, () -> SILab2.checkCart(t, 0));
        assertEquals("Invalid character in item barcode!", e.getMessage());

        t.clear();
        i = new Item("supa", null, 301, 0.9F);
        t.add(i);
        Exception e1 = assertThrows(Exception.class, () -> SILab2.checkCart(t, 300));
        assertEquals("No barcode!", e1.getMessage());

        t.clear();
        Exception e2 = assertThrows(Exception.class, () -> SILab2.checkCart(null, 0));
        assertEquals("allItems list can't be null!", e2.getMessage());
    }

    @Test
    public void test2() {
        List<Item> t = new ArrayList<>(1);
        Item i = new Item("supa", "0", 301, 0.9F);
        t.add(i);
        assertEquals(SILab2.checkCart(t, 241), true);

        t.clear();
        i = new Item("supa", "1", 301, 0.9F);
        t.add(i);
        assertEquals(SILab2.checkCart(t, 241), false);

        t.clear();
        i = new Item("supa", "0", 301, 0);
        t.add(i);
        assertEquals(SILab2.checkCart(t, 300), false);

        t.clear();
        i = new Item("supa", "0", 300, 0);
        t.add(i);
        assertEquals(SILab2.checkCart(t, 300),true);
    }
}
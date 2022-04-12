import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestKlasse {

    Abhaengigkeit a;

    @BeforeEach
    public void before(){
        a = new Abhaengigkeit(new String[][]{{"A","C"},{"C","D"},{"B","C"},});

    }

    @AfterEach
    public void after(){
        a = null;
    }

    @Test
    public void testIsWellSorted(){
        boolean test3 = a.isWellSorted(new String[]{"D","A","C"});
        boolean test1 = a.isWellSorted(new String[]{"A","B","C","D"});
        boolean test2 = a.isWellSorted(new String[]{"D","C","B","A"});
        assertFalse(test3,"D kommt vor C");
        assertTrue(test1,"Error :( Sollte true sein, ist aber false");
        assertFalse(test2,"Error :( Sollte false sein, ist aber true");
    }

    @Test
    public void transitiv(){
        a = new Abhaengigkeit(new String[][]{{"A","B"},{"B","C"}});
        boolean test4 = a.isWellSorted(new String[]{"C","A"});
        assertFalse(test4,"geht nicht");

    }


}
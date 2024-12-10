import org.junit.Test;
import static org.junit.Assert.*;

public class UtilityTest {

    @Test
    public void testAddition() {
        assertEquals(5, Utility.add(2, 3));
    }

    @Test
    public void testDivisionByZero() {
        try {
            Utility.divide(4, 0);
            fail("Expected an ArithmeticException to be thrown");
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }
}

class Utility {
    static int add(int a, int b) {
        return a + b;
    }

    static int divide(int a, int b) {
        return a / b;
    }
}

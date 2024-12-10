import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class UtilityTest {

    @Test
    fun testAddition() {
        assertEquals(5, Utility.add(2, 3))
    }

    @Test
    fun testDivisionByZero() {
        val exception = assertFailsWith<ArithmeticException> {
            Utility.divide(4, 0)
        }
        assertEquals("/ by zero", exception.message)
    }
}

object Utility {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun divide(a: Int, b: Int): Int {
        return a / b
    }
}

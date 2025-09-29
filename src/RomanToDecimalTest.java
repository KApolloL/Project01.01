import static org.junit.Assert.*;

/**
 * JUnit4 test class for RomanToDecimal
 * @author 26lee
 * @version 09.30.2025
 */
public class RomanToDecimalTest {

    /**
     * JUnit test method for romanToDecimal method
     */
    @org.junit.Test
    public void romanToDecimal() {
        //18 of these
        assertEquals(RomanToDecimal.romanToDecimal("I"), 1);
        assertEquals(RomanToDecimal.romanToDecimal("IV"), 4);

        //2 of these
        assertNotEquals(RomanToDecimal.romanToDecimal("IV"), 1);
    }
}
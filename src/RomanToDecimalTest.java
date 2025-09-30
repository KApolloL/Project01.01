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
        assertEquals(12, RomanToDecimal.romanToDecimal("XII"));
        assertEquals(13, RomanToDecimal.romanToDecimal("XIII"));
        assertEquals(16, RomanToDecimal.romanToDecimal("XVI"));
        assertEquals(17, RomanToDecimal.romanToDecimal("XVII"));
        assertEquals(42, RomanToDecimal.romanToDecimal("XLII"));
        assertEquals(67, RomanToDecimal.romanToDecimal("LXVII"));
        assertEquals(692, RomanToDecimal.romanToDecimal("DCXCII"));
        assertEquals(88, RomanToDecimal.romanToDecimal("LXXXVIII"));
        assertEquals(347, RomanToDecimal.romanToDecimal("CCCXLVII"));
        assertEquals(2763, RomanToDecimal.romanToDecimal("MMDCCLXIII"));
        assertEquals(-1, RomanToDecimal.romanToDecimal("IIX"));
        assertEquals(-1, RomanToDecimal.romanToDecimal("VIX"));
        assertEquals(-1, RomanToDecimal.romanToDecimal("CCM"));
        assertEquals(-1, RomanToDecimal.romanToDecimal("MIMI"));
        assertEquals(-1, RomanToDecimal.romanToDecimal("ROMAN"));
        assertEquals(-1,RomanToDecimal.romanToDecimal("C0CHR@N"));
        assertEquals(-1, RomanToDecimal.romanToDecimal("XIIS"));
        assertEquals(-1, RomanToDecimal.romanToDecimal("A13XR()"));

        //2 of these
        assertNotEquals(15, RomanToDecimal.romanToDecimal("XII"));
        assertNotEquals(500, RomanToDecimal.romanToDecimal("CDXL"));
    }
}
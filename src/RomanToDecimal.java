//import libraries
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Converts roman numeral strings to their corresponding decimal integer.
 * Validation rules:
 * Only I, V, X, C, L, D, M allowed
 * V, L, D can't be repeated and I, X, C, M can be repeated 3 times
 * Only valid subtraction pairs:
 *  I before V or X
 *  X before L or C
 *  C before D or M
 * No multiple subtraction
 * No invalid ordering or repetitions
 *
 * @author 26lee
 * @version 09.30.2025
 */
public class RomanToDecimal {
    /**
     * Converts roman numeral string to decimal integer
     * Returns -1 if the input is invalid
     *
     * @param roman Roman numeral string (case-insensitive)
     * @return Decimal integer value after conversion or -1 if invalid
     */

    public static int romanToDecimal(String roman) {
        // Returns invalid for empty or null roman strings
        if (roman == null || roman.isEmpty()) return -1;

        roman = roman.toUpperCase(); //normalize to uppercase

        String validRomans = "IVXLCDM"; //allowed roman numerals

        //mapping roman numerals to their values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;
        int repeatCount = 1;
        char prevChar = ' ';

        // Validate all characters are roman numerals
        for (int i = 0; i < roman.length(); i++) {
            String currentChar = roman.substring(i, i + 1);

            if (validRomans.indexOf(currentChar) == -1) {
                return -1;
            }
        }

        // Process roman numeral characters
        for (int i = 0; i < roman.length(); i++) {
            char currentChar = roman.charAt(i);
            int value = romanMap.get(currentChar);

            //Disallow repetitions
            if (currentChar == prevChar) {
                repeatCount++;
                if ((currentChar == 'V' || currentChar == 'L' || currentChar == 'D') && repeatCount > 1) {
                    return -1; // V, L, D cannot repeat
                }
                if ((currentChar == 'I' || currentChar == 'X' || currentChar == 'C' || currentChar == 'M') && repeatCount > 3) {
                    return -1; // I, X, C, M cannot repeat 4+ times
                }
            } else {
                repeatCount = 1;
            }

            if (i+1 < roman.length()) {
                int nextValue = romanMap.get(roman.charAt(i+1));

                // can't repeat before subtraction
                if (value < nextValue) {
                    if (repeatCount > 1) {
                        return -1;
                    }

                    //only allow the correct subtractive rules
                    if (!((roman.charAt(i) == 'I' && (roman.charAt(i + 1) == 'V' || roman.charAt(i + 1) == 'X')) ||
                            (roman.charAt(i) == 'X' && (roman.charAt(i + 1) == 'L' || roman.charAt(i + 1) == 'C')) ||
                            (roman.charAt(i) == 'C' && (roman.charAt(i + 1) == 'D' || roman.charAt(i + 1) == 'M')))) {
                        return -1;
                    }

                    if (i + 2 < roman.length() && Objects.equals(romanMap.get(roman.charAt(i)), romanMap.get(roman.charAt(i + 2)))) {
                        return -1;
                    }

                    total += (nextValue - value);
                    prevValue = nextValue;
                    i++;
                } else {
                    //check for correct order
                    if (value > prevValue && prevValue != 0) {
                        return -1;
                    }

                    total += value;
                    prevValue = value;
                }
            } else {
                if (value > prevValue && prevValue != 0) {
                    return -1;
                }
                total += value;
                prevValue = value;
            }
            prevChar = currentChar;
        }
        return total;
    }

    /**
     * Main method for class RomanToDecimal
     * @param args command line arguments, if needed
     */
    public static void main(String[] args) {
        int decimal = 0;

        for (String s : args) {
            decimal = romanToDecimal(s);
            System.out.println("Input: " + s + " => output: " + (decimal != -1 ? decimal : "invalid"));
        }
    }
}
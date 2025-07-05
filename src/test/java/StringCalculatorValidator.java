import org.nisarg.StringCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorValidator {
    StringCalculator calculator = new StringCalculator();

    // No Input
    @Test
    void validateNullInput() {
        int result = calculator.add("");
        assertEquals(0, result);
    }

    // Single Number Input
    @Test
    void validateSingleNumberInput() {
        int result = calculator.add("1");
        assertEquals(1, result);
    }

    // Comma Separated Two Number Input
    @Test
    void validateTwoNumberInput() {
        int result = calculator.add("1,2");
        assertEquals(3, result);
    }

    // Handle any amount of numbers
    @Test
    void validateAnyAmountOfNumberInput() {
        int result = calculator.add("1,2,3,4,5");
        assertEquals(15, result);
    }

    // Handle new lines between numbers
    @Test
    void validateInputWithNewLine() {
        int result = calculator.add("1\n2,3");
        assertEquals(6, result);
    }

    // Handle delimiter separated numbers
    @Test
    void validateDelimiterSeperatedNumbers() {
        int result = calculator.DelimiterWithNumbers("//;\n1;2");
        assertEquals(3, result);
    }

    // Handle default delimiter separated numbers
    @Test
    void validateDefaultDelimiterSeperatedNumbers() {
        int result = calculator.DelimiterWithNumbers("1\n2,3");
        assertEquals(6, result);
    }

    // Handle empty string of numbers
    @Test
    void validateEmptyStringNumbers() {
        int result = calculator.DelimiterWithNumbers("");
        assertEquals(0, result);
    }

    // Handle string with delimiter and empty numbers
    @Test
    void validateWithDelimiterWithoutNumbersInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.DelimiterWithNumbers("//;\n");
        });
    }

    // Handle string with negative numbers
    @Test
    void validateStringWithNegativeNumbers() {
        RuntimeException message =  assertThrows(RuntimeException.class, () -> {
            calculator.add("1,-1,2,-2,3,-3");
        });

        System.out.println(message.getMessage());
    }

    // Handle number bigger than 1000
    @Test
    void validateNumberGreaterThan1000() {
        int result = calculator.add("2,1001,1");
        assertEquals(3, result);
    }

    // Handle delimiter of any length
    @Test
    void validateDelimiterWithAnyLength() {
        int result = calculator.DelimiterWithAnyLength("//[***]\n1***2***3");
        assertEquals(6, result);
    }

    // Handle multiple custom delimiter
    @Test
    void validateCustomDelimiter() {
        int result = calculator.addWithMultipleCustomDelimiter("//[*][%]\n1*2%3");
        assertEquals(6, result);
    }

    // Handle multiple delimiters with length longer than one char
    @Test
    void validateCustomDelimiterLengthLongerThanOne() {
        int result = calculator.addWithMultipleCustomDelimiter("//[**][%]\n1**2%3");
        assertEquals(6, result);
    }
}
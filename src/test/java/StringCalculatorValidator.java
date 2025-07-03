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
}
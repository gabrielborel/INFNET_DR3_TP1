import devcalc.services.CalculatorService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {
    CalculatorService calculator = new CalculatorService();

    @Test
    void testAdd() {
        assertEquals(15, calculator.add(10, 5));
        assertEquals(0, calculator.add(-2, 2));
        assertEquals(30, calculator.add(29, 1));
        assertEquals(-10,  calculator.add(-5, -5));
        assertEquals(100, calculator.add(50, 50));
        assertEquals(1000, calculator.add(500, 500));
        assertEquals(10000, calculator.add(9999, 1));
        assertEquals(1000000, calculator.add(999999, 1));
        assertEquals(1000000000, calculator.add(999999999, 1));
    }

    @Test
    void testSubtract() {
        assertEquals(5, calculator.subtract(10, 5));
        assertEquals(-4, calculator.subtract(2, 6));
        assertEquals(28, calculator.subtract(29, 1));
        assertEquals(0, calculator.subtract(5, 5));
        assertEquals(50, calculator.subtract(100, 50));
        assertEquals(500, calculator.subtract(1000, 500));
        assertEquals(9998, calculator.subtract(9999, 1));
        assertEquals(999999, calculator.subtract(1000000, 1));
        assertEquals(999999998, calculator.subtract(1000000000, 2));
    }

    @Test
    void testMultiply() {
        assertEquals(50, calculator.multiply(10, 5));
        assertEquals(0, calculator.multiply(0, 100));
        assertEquals(29, calculator.multiply(29, 1));
        assertEquals(25, calculator.multiply(5, 5));
        assertEquals(5000, calculator.multiply(100, 50));
        assertEquals(80000, calculator.multiply(1000, 80));
        assertEquals(9999, calculator.multiply(9999, 1));
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(10, 5));
        assertEquals(3, calculator.divide(7, 2));
        assertEquals(29, calculator.divide(29, 1));
        assertEquals(1, calculator.divide(5, 5));
        assertEquals(2, calculator.divide(100, 50));
        assertEquals(2, calculator.divide(1000, 500));
        assertEquals(9999, calculator.divide(9999, 1));
        assertEquals(1000000, calculator.divide(1000000, 1));
        assertEquals(1000000000, calculator.divide(1000000000, 1));
        assertEquals(1, calculator.divide(1000000000, 1000000000));
    }

    @Test
    void testSqrt() {
        assertEquals(3, calculator.sqrt(9));
        assertEquals(4, calculator.sqrt(16));
        assertEquals(5, calculator.sqrt(25));
        assertEquals(6, calculator.sqrt(36));
        assertEquals(7, calculator.sqrt(49));
        assertEquals(8, calculator.sqrt(64));
        assertEquals(9, calculator.sqrt(81));
        assertEquals(10, calculator.sqrt(100));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Division by zero", exception.getMessage());
    }
}

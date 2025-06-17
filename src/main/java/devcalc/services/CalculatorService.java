package devcalc.services;

/**
 * Serviço de operações matemáticas básicas.
 */
public final class CalculatorService {

    /**
     * Soma dois inteiros.
     *
     * @param a o primeiro número
     * @param b o segundo número
     * @return a soma de a e b
     */
    public int add(final int a, final int b) {
        return a + b;
    }

    /**
     * Subtrai dois inteiros.
     *
     * @param a o primeiro número
     * @param b o segundo número
     * @return o resultado de a - b
     */
    public int subtract(final int a, final int b) {
        return a - b;
    }

    /**
     * Multiplica dois inteiros.
     *
     * @param a o primeiro número
     * @param b o segundo número
     * @return o resultado da multiplicação de a e b
     */
    public int multiply(final int a, final int b) {
        return a * b;
    }

    /**
     * Divide dois inteiros.
     *
     * @param a o numerador
     * @param b o denominador
     * @return o resultado da divisão de a por b
     * @throws ArithmeticException se b for igual a zero
     */
    public int divide(final int a, final int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}

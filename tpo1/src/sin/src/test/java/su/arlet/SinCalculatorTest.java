package su.arlet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SinCalculatorTest {
    private final SinCalculator calculator = new SinCalculator();

    @Test
    void calcZero() {
        var expectedResult = 0;

        var result = calculator.calc(0, 5);

        assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "sin({0})")
    @ValueSource(doubles = {-2 * Math.PI, -Math.PI, 0, Math.PI, 2 * Math.PI, 3 * Math.PI})
    void calcPIValues(double param) {
        var expectedResult = 0;

        var result = calculator.calc(param, 100);

        assertEquals(expectedResult, result, 0.1);
    }

    @ParameterizedTest(name = "sin({0})")
    @ValueSource(doubles = {-3 * Math.PI / 2, Math.PI / 2, 5 * Math.PI / 2})
    void calcUpperHalfPIValues(double param) {
        var expectedResult = 1;

        var result = calculator.calc(param, 100);

        assertEquals(expectedResult, result, 0.1);
    }

    @ParameterizedTest(name = "sin({0})")
    @ValueSource(doubles = {-1 * Math.PI / 2, 3 * Math.PI / 2, 7 * Math.PI / 2})
    void calcLowerHalfPIValues(double param) {
        var expectedResult = -1;

        var result = calculator.calc(param, 100);

        assertEquals(expectedResult, result, 0.1);
    }

    @ParameterizedTest(name = "sin({0})")
    @ValueSource(doubles = {
            -7 * Math.PI / 4, -5 * Math.PI / 4,
            Math.PI / 4, 3 * Math.PI / 4,
            9 * Math.PI / 4, 11 * Math.PI / 4
    })
    void calcUpperQuarters(double parameter) {
        var expectedResult = 0.7071067811865475; // value on 45 degrees

        var result = calculator.calc(parameter, 100);

        assertEquals(expectedResult, result, 0.001);
    }

    @ParameterizedTest(name = "sin({0})")
    @ValueSource(doubles = {
            -3 * Math.PI / 4, -Math.PI / 4,
            5 * Math.PI / 4, 7 * Math.PI / 4,
            13 * Math.PI / 4, 15 * Math.PI / 4
    })
    void calcLowerQuarters(double parameter) {
        var expectedResult = -0.7071067811865475; // value on 45 degrees

        var result = calculator.calc(parameter, 100);

        assertEquals(expectedResult, result, 0.001);
    }
}
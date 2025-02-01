package org.iti.app_tests;

import org.iti.app.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CalculatorTests {
    private static Calculator calculator;

    @AfterAll
    static void afterAll() {
        System.out.println("After All Methods");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All Methods");
        calculator = new Calculator();
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(5, 6, 11),
                Arguments.of(-5, -6, -11),
                Arguments.of(-5, 6, 1),
                Arguments.of(5, -6, -1),
                Arguments.of(0, 6, 6),
                Arguments.of(7, 0, 7));
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Before Methods");
    }

    @AfterEach
    void AfterEachTest() {
        System.out.println("After Methods");
    }

    @DisplayName("ABC-123 Test add functionality")
    @Tag("FEB")
    @ParameterizedTest
    @MethodSource(value = "provideTestData")
    void testAddition(double input1, double input2, double result) {
        assertEquals(result, calculator.add(input1, input2));
    }

    @Test
    @DisplayName("ABC-123 Test sub functionality")
    @Tag("MAY")
    void testSubtraction() {
        // Arrange


        // Act
        // Assert
        assertEquals(-1, calculator.sub(5, 6));
        assertEquals(1, calculator.sub(-5, -6));
        assertEquals(11, calculator.sub(5, -6));
        assertEquals(-6, calculator.sub(0, 6));
        assertEquals(7, calculator.sub(7, 0));
    }

    @Test
    @DisplayName("ABC-123 Test mul functionality")
    //@EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_12)
    @DisabledOnOs(OS.MAC)
    void testMultiplication() {
        // Arrange


        // Act
        // Assert
        assertEquals(30, calculator.mul(5, 6));
        assertEquals(30, calculator.mul(-5, -6));
        assertEquals(-30, calculator.mul(5, -6));
        assertEquals(0, calculator.mul(0, 6));
        assertEquals(0, calculator.mul(7, 0));
    }

    @Test
    @DisplayName("ABC-123 Test div functionality")
    void testDivision() {
        // Arrange


        // Act
        // Assert
        assertEquals(1, calculator.div(6, 6));
        assertEquals(1, calculator.div(-6, -6));
        assertEquals(-1, calculator.div(6, -6));
        assertEquals(0, calculator.div(0, 6));

        var ex = assertThrowsExactly(IllegalArgumentException.class, () -> calculator.div(6, 0));
        assertEquals("Division by zero", ex.getMessage());

    }

    @DisplayName("ABC-123 Test sqrt functionality")
    @Tag("FEB")
    @RepeatedTest(5)
    void testSquareRoot() {
        // Arrange


        // Act
        // Assert
        assertEquals(15, calculator.squareRoot(225));
        assertEquals(12, calculator.squareRoot(144));
        assertEquals(0, calculator.squareRoot(0));
        assertEquals(25, calculator.squareRoot(625));
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testTimeOut() throws InterruptedException {
        Thread.sleep(4900);
    }


}

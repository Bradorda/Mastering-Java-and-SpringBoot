package com.bradorda.math;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMathClass")
public class SimpleMathTest {

    SimpleMath math;

    @BeforeAll
    static void setup(){
        System.out.println("Running @BeforeAll method!");
    }

    @AfterAll
    static void cleanup(){
        System.out.println("Running @AfterAll method!");
    }

    @BeforeEach
    void beforeEachMethod(){
        math = new SimpleMath();
        System.out.println("Running @BeforeEach method!");
    }

    @AfterEach
    void afterEachMethod(){
        System.out.println("Running @AfterEach method!");
    }

    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo(){
        //Given / Arrange
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        double expected = 8.2D;

        //When / Act
        Double actual = math.sum(firstNumber, secondNumber);;

        //Then / Assert
        assertEquals(expected, actual,() -> "%s + %s did not produce expected result"
                .formatted(firstNumber,secondNumber));
        assertNotEquals(9.2, actual,"The testSum()");
        assertNotNull(actual);
    }

    //@Disabled("TODO: ainda precisamos trabalhar nesse metodo")
    @Test
    @DisplayName("Divisão por 0")
    void testDivision_WhenFirstNumberIsDividedByZero_ShouldThrowArithmeticException(){
        //given
        double firstNumber = 6.2D;
        double secondNumber = 0D;

        var expectedMessage = "impossivel dividir por zero";

        //when & then
        ArithmeticException actual = assertThrows(
                ArithmeticException.class, () -> {
                    //when & then
                    math.division(firstNumber, secondNumber);
                }, () -> "division by zero should throw an ArithmeticException");

        assertEquals(expectedMessage, actual.getMessage(),
                () -> "Unexpected exception message");
    }

    @Test
    @DisplayName("Test 6.2 - 2 = 4.2")
    void testSubtraction(){
        double expected = 4.2D;
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.subtraction(firstNumber, secondNumber);;

        assertEquals(expected, actual,() -> "%s - %s did not produce expected result"
                .formatted(firstNumber,secondNumber));
        assertNotEquals(9.2, actual,"The testSum()");
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test 6.2 * 2 = 12.4")
    void testMultiplication(){
        double expected = 12.4D;
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.multiplication(firstNumber, secondNumber);;

        assertEquals(expected, actual,() -> "%s * %s did not produce expected result"
                .formatted(firstNumber,secondNumber));
        assertNotEquals(9.2, actual,"The testSum()");
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test 6.2 / 2 = 3.1")
    void testDivision(){
        double expected = 3.1D;
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.division(firstNumber, secondNumber);;

        assertEquals(expected, actual,() -> "%s / %s did not produce expected result"
                .formatted(firstNumber,secondNumber));
        assertNotEquals(9.2, actual,"The testSum()");
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test (6.2 + 2) = 4.1")
    void testMean(){
        double expected = 4.1D;
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double actual = math.mean(firstNumber, secondNumber);;

        assertEquals(expected, actual,() -> "%s + %s /2 did not produce expected result"
                .formatted(firstNumber,secondNumber));
        assertNotEquals(9.2, actual,"The testSum()");
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test square root of 81 = 9")
    void testSquareRoot(){
        double expected = 9D;
        double number = 81D;
        Double actual = math.squareRoot(number);;

        assertEquals(expected, actual,() -> "%s did not produce expected result"
                .formatted(number));
        assertNotEquals(9.2, actual,"The testSum()");
        assertNotNull(actual);

    }

}

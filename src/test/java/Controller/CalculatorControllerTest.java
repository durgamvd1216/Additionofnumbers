package Controller;

import org.example.CalculatorService.CalculatorService;
import org.example.controller.CalculatorController;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorControllerTest {

    @Test
    public void testAddNumbers() {
        // Arrange
        int num1 = 5;
        int num2 = 3;
        int expectedSum = 8;

        CalculatorController additionController = new CalculatorController(new CalculatorService());

        // Act
        CalculatorController.Result result = additionController.addNumbers(num1, num2);

        // Assert
        assertEquals(expectedSum, result.getResult());
        assertEquals(num1, result.getNum1());
        assertEquals(num2, result.getNum2());
    }

    @Test
    public void testAddNumbersWithNegativeNumbers() {
        // Arrange
        int num1 = -5;
        int num2 = 3;
        int expectedSum = -2;

        CalculatorController additionController = new CalculatorController(new CalculatorService());

        // Act
        CalculatorController.Result result = additionController.addNumbers(num1, num2);

        // Assert
        assertEquals(expectedSum, result.getResult());
        assertEquals(num1, result.getNum1());
        assertEquals(num2, result.getNum2());
    }


    @Test
    public void testSubNumbers() {
        // Arrange
        CalculatorController calculatorController = new CalculatorController(new CalculatorService());
        CalculatorController.NumbersRequest request = new CalculatorController.NumbersRequest();
        request.setNum1(10);
        request.setNum2(5);
        int expectedResult = 5;

        // Act
        CalculatorController.Result result = calculatorController.subNumbers(request);

        // Assert
        assertEquals(expectedResult, result.getResult());
        assertEquals(request.getNum1(), result.getNum1());
        assertEquals(request.getNum2(), result.getNum2());
    }

    @Test
    public void testSubNumbersWithNegativeNumbers() {
        // Arrange
        CalculatorController calculatorController = new CalculatorController(new CalculatorService());
        CalculatorController.NumbersRequest request = new CalculatorController.NumbersRequest();
        request.setNum1(5);
        request.setNum2(-3);
        int expectedResult = 8;

        // Act
        CalculatorController.Result result = calculatorController.subNumbers(request);

        // Assert
        assertEquals(expectedResult, result.getResult());
        assertEquals(request.getNum1(), result.getNum1());
        assertEquals(request.getNum2(), result.getNum2());
    }

}



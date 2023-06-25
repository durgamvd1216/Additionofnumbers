package Controller;

import org.example.CalculatorService.CalculatorService;
import org.example.controller.CalculatorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(expectedSum, result.getResult());
        Assertions.assertEquals(num1, result.getNum1());
        Assertions.assertEquals(num2, result.getNum2());
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
        Assertions.assertEquals(expectedSum, result.getResult());
        Assertions.assertEquals(num1, result.getNum1());
        Assertions.assertEquals(num2, result.getNum2());
    }
}


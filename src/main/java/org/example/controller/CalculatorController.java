package org.example.controller;

import org.example.CalculatorService.CalculatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/add")
    public Result addNumbers(@RequestParam int num1, @RequestParam int num2) {
        int result = CalculatorService.addNumbers(num1, num2);

        return new Result(result, num1, num2);
    }
    @PostMapping("/subtract")
    public Result subNumbers(@RequestBody NumbersRequest numbersRequest) {
        int result = calculatorService.subNumbers(numbersRequest.getNum1(), numbersRequest.getNum2());
        return new Result(result, numbersRequest.getNum1(), numbersRequest.getNum2());
    }


    public static class NumbersRequest {
        private int num1;
        private int num2;

        // getters and setters

        public int getNum1() {
            return num1;
        }

        public void setNum1(int num1) {
            this.num1 = num1;
        }

        public int getNum2() {
            return num2;
        }

        public void setNum2(int num2) {
            this.num2 = num2;
        }
    }

    public static class Result {
        private int result;
        private int num1;
        private int num2;

        // getters and setters

        public Result(int result, int num1, int num2) {
            this.result = result;
            this.num1 = num1;
            this.num2 = num2;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public int getNum1() {
            return num1;
        }

        public void setNum1(int num1) {
            this.num1 = num1;
        }

        public int getNum2() {
            return num2;
        }

        public void setNum2(int num2) {
            this.num2 = num2;
        }
    }
}

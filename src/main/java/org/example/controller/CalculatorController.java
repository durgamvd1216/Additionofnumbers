package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @GetMapping("/add")
    public int addNumbers(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + num2;
    }
}

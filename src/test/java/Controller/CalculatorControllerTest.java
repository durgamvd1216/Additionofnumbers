package Controller;

import org.example.CalculatorService.CalculatorService;
import org.example.controller.CalculatorController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

public class CalculatorControllerTest {
    @WebMvcTest(CalculatorController.class)
    public class AdditionControllerTest {

        @Mock
        private CalculatorService calculatorService;

        @InjectMocks
        private CalculatorController CalculatorController;

        private MockMvc mockMvc;

        @BeforeEach
        public void setup() {
            MockitoAnnotations.openMocks(this);
            mockMvc = MockMvcBuilders.standaloneSetup(CalculatorController).build();
        }

        @Test
        public void testAddNumbers() throws Exception {
            int num1 = 5;
            int num2 = 3;
            int expectedResult = 8;

            when(CalculatorService.addNumbers(num1, num2)).thenReturn(expectedResult);
            mockMvc.perform(MockMvcRequestBuilders.get("/add")
                            .param("num1", String.valueOf(num1))
                            .param("num2", String.valueOf(num2)))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string(String.valueOf(expectedResult)));
        }
    }


}



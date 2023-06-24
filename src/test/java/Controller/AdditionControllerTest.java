package Controller;

import org.example.CalculatorService.CalculatorService;
import org.example.controller.CalculatorController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

    @WebMvcTest(CalculatorController.class)
    @AutoConfigureMockMvc
    public class AdditionControllerTest {

        @Mock
        private CalculatorService calculatorService;

        @InjectMocks
        private CalculatorController calculatorController;

        private MockMvc mockMvc;

        @BeforeEach
        public void setup() {
            MockitoAnnotations.initMocks(this);
            mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();
        }

        @Test
        public void testAddNumbers() throws Exception {
            int num1 = 5;
            int num2 = 3;
            int expectedResult = 8;

            when(calculatorService.addNumbers(num1, num2)).thenReturn(expectedResult);

            mockMvc.perform(MockMvcRequestBuilders.get("/add")
                            .param("num1", String.valueOf(num1))
                            .param("num2", String.valueOf(num2))
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(expectedResult))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.num1").value(num1))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.num2").value(num2));
        }
        @Test
        public void testAddNumbers_Failed() throws Exception {
            // Test case for failed addition
            int num1 = 5;
            int num2 = 3;
            int expectedResult = 10;  // Incorrect expected result

            when(calculatorService.addNumbers(num1, num2)).thenReturn(expectedResult);

            mockMvc.perform(MockMvcRequestBuilders.get("/add")
                            .param("num1", String.valueOf(num1))
                            .param("num2", String.valueOf(num2))
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(result -> {
                        String response = result.getResponse().getContentAsString();
                        String expectedResponse = String.format("{\"result\":%d,\"num1\":%d,\"num2\":%d}", expectedResult, num1, num2);
                        if (response.equals(expectedResponse)) {
                            throw new AssertionError("Response matches incorrect expected value");
                        }
                    });
        }
    }




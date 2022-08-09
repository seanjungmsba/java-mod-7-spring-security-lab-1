package com.example.springunittesting2.bitcoin;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BitcoinController.class)
public class BitcoinControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BitcoinService bitcoinService;

    @Test
    void getPrice() throws Exception {
        BigDecimal value = BigDecimal.valueOf(23931.5186364977489630);

        Mockito.when(bitcoinService.getBitcoinPrice()).thenReturn(value);
        // perform() method lets us pass in a http verb, along with the appropriate parameters for that call.
        // In this case, we are asking for a GET request to be executed and pass in the URL to which it should be submitted.
        mockMvc.perform(get("/getprice"))
                // andDo(print()) call asks mockMvc to results of perform() call to the console - we can use this to diagnose potential issues
                .andDo(print())
                // andExpect(status().isOk()) call tells mockMvc that we want an HTTP status code of 200 to be returned as a result of perform() call
                .andExpect(status().isOk())
                // tells mockMvc that we want the content of the response of perform() call to contain the string "Hello Stephanie".
                .andExpect(content().string(containsString(String.valueOf(value))));
    }
}

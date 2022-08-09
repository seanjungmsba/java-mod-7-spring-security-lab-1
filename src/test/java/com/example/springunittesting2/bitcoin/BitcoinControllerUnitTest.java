package com.example.springunittesting2.bitcoin;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BitcoinControllerUnitTest {
    @Test // this test cares if I defined getBitcoinPrice() method correctly
    void getBitcoinPrice() {
        BitcoinService bitcoinService = Mockito.mock(BitcoinService.class);
        BigDecimal expected = BigDecimal.valueOf(23456.24);
        BitcoinController bitcoinController = new BitcoinController(bitcoinService);
        when(bitcoinService.getBitcoinPrice()).thenReturn(expected);
        System.out.println("expected: " + expected); // 23456.24
        BigDecimal actual = bitcoinController.getBitcoinPrice();
        System.out.println("actual: " + actual);
        assertEquals(expected, actual);
    }
}
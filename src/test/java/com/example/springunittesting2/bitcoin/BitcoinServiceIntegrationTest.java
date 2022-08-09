package com.example.springunittesting2.bitcoin;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class BitcoinServiceIntegrationTest {

    @Test // passed
    void shouldReturnPrice() {
        BitcoinService bitCoinService = new BitcoinService();
        BigDecimal currentPrice = bitCoinService.getBitcoinPrice();
        assertThat(currentPrice).isNotNull();
    }
    @Test // passed
    void shouldReturnConstantBitcoinPrice() {
        BitcoinService bitcoinService = new BitcoinService();
        BigDecimal firstBitcoinPrice = bitcoinService.getBitcoinPrice();
        assertThat(firstBitcoinPrice).isNotNull();
        BigDecimal secondBitcoinPrice = bitcoinService.getBitcoinPrice();
        assertThat(secondBitcoinPrice).isNotNull();
        assertThat(firstBitcoinPrice).isEqualTo(secondBitcoinPrice);
    }
}

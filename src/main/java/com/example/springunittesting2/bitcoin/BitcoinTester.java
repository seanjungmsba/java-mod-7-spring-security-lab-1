package com.example.springunittesting2.bitcoin;

import java.math.BigDecimal;

public class BitcoinTester {
    public static void main(String[] args) {
        BitcoinService bitcoinService = new BitcoinService();
        BigDecimal price = bitcoinService.getBitcoinPrice();
        System.out.println("Bitcoin Price: $" + price);
    }
}

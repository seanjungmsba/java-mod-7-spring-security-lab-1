package com.example.springsecurity1.crypto;

import java.math.BigDecimal;

public class BitcoinTester {

    private static final String cryptoName = "bitcoin";
    public static void main(String[] args) {
        CryptoService cryptoService = new CryptoService();
        String id = cryptoService.getCryptoName(cryptoName);
        BigDecimal price = cryptoService.getCryptoPrice(cryptoName);
        System.out.println(cryptoName + " Id: "  + id + " | "  +  cryptoName + " Price: $" + price);
    }
}

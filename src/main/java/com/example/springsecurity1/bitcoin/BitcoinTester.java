package com.example.springsecurity1.bitcoin;

import java.math.BigDecimal;

public class BitcoinTester {
    public static void main(String[] args) {
        CryptoService cryptoService = new CryptoService();
        String id = cryptoService.getCryptoName();
        BigDecimal price = cryptoService.getCryptoPrice("");
        System.out.println("Bitcoin Id: "  + id + " | "  + "Bitcoin Price: $" + price);
    }
}

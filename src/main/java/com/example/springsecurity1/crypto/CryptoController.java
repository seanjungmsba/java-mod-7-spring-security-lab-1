package com.example.springsecurity1.crypto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController("/crypto")
public class CryptoController {

    // We create a private instance variable jokeService to get access to the service's methods
    private CryptoService cryptoService;

    // Since our BitcoinService class has the @Service annotation,
    // the Spring framework will take care of passing in an instance of the joke service into the BitcoinController() constructor
    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/{cryptoName}")
    public BigDecimal getCryptoPrice(@PathVariable(value = "cryptoName") String cryptoName) {
        BigDecimal price = cryptoService.getCryptoPrice(cryptoName);
        return price;
    }

    @GetMapping("/{cryptoName}")
    public String getCryptoName(@PathVariable(value = "cryptoName") String cryptoName) {
        String name = cryptoService.getCryptoName(cryptoName);
        return name;
    }
}

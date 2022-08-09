package com.example.springsecurity1.bitcoin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController("/BTC")
public class CryptoController {

    // We create a private instance variable jokeService to get access to the service's methods
    private CryptoService cryptoService;

    // Since our BitcoinService class has the @Service annotation,
    // the Spring framework will take care of passing in an instance of the joke service into the BitcoinController() constructor
    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/price")
    public BigDecimal getCryptoPrice(String cryptoName) {
        BigDecimal price = cryptoService.getCryptoPrice(cryptoName);
        return price;
    }

    @GetMapping("/id")
    public String getCryptoName() {
        String id = cryptoService.getCryptoName();
        return id;
    }

    @GetMapping("/{cryptoName}")
    public String cryptoURL(@RequestParam(name = "cryptoname", defaultValue = "bitcoin")
                                @PathVariable(value = "cryptoName") String cryptoName) {
        return String.format("https://api.coincap.io/v2/assets/", cryptoName);
    }

}

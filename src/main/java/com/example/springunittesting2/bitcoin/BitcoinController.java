package com.example.springunittesting2.bitcoin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class BitcoinController {

    // We create a private instance variable jokeService to get access to the service's methods
    private BitcoinService bitcoinService;

    // Since our BitcoinService class has the @Service annotation,
    // the Spring framework will take care of passing in an instance of the joke service into the BitcoinController() constructor
    public BitcoinController(BitcoinService bitcoinService) {
        this.bitcoinService = bitcoinService;
    }

    @GetMapping("/getprice")
    public BigDecimal getBitcoinPrice() {
        BigDecimal price = bitcoinService.getBitcoinPrice();
        return price;
    }
}

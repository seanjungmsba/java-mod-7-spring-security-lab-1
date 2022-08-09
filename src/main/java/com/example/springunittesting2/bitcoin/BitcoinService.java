package com.example.springunittesting2.bitcoin;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class BitcoinService {
    public BigDecimal getBitcoinPrice() {
        try {
            String apiURL = "https://api.coincap.io/v2/assets/bitcoin/";
            // We use the RestTemplate class to make a request to the URL for the Joke API
            RestTemplate restTemplate = new RestTemplate();
            // We use the getForObject() method and tell it to take the return of the call to the URL and convert its JSON return to a Java object
            // We define the Java object as a simple POJO that has 3 properties that match the JSON that the API returns
            // The getForObject method takes care of converting JSON to Java and returns an object of type DadJoke
            // We can then take the joke property of the DadJoke object and return it to the caller
            Data data = restTemplate.getForObject(apiURL, Data.class);
            BitcoinData bitcoinData = data.getData();
            BigDecimal bitcoinPrice = bitcoinData.getPriceUsd();
            return bitcoinPrice;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("something went wrong");
        }
        return null;
    }

}

class BitcoinData {
    public String id;
    public BigDecimal priceUsd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(BigDecimal priceUsd) {
        this.priceUsd = priceUsd;
    }
}

class Data {
    private BitcoinData data;
    public BitcoinData getData() {
        return data;
    }
    public void setData(BitcoinData data) {
        this.data = data;
    }
}


package com.ndynmate.stockmarket;

import com.ndynmate.stockmarket.constant.Currency;
import com.ndynmate.stockmarket.impl.CoinGeckoApiClientImpl;

import java.util.Map;

public class SimpleExample {
    public static void main(String[] args) {
        CoinGeckoApiClient client = (CoinGeckoApiClient) new CoinGeckoApiClientImpl();

        Map<String, Map<String, Double>> bitcoin = client.getPrice("bitcoin", Currency.USD,false,true,true,true);
        Map<String, Map<String, Double>> cardano = client.getPrice("cardano",Currency.EUR);
        Map<String, Map<String, Double>> ethereum = client.getPrice("ethereum",Currency.EUR);

        System.out.println(bitcoin);
        System.out.println(cardano);
        System.out.println(ethereum);

        double bitcoinPrice = bitcoin.get("bitcoin").get(Currency.USD);
        double cardanoPrice = cardano.get("cardano").get(Currency.EUR);
        double ethereumPrice = ethereum.get("ethereum").get(Currency.EUR);

        System.out.println(bitcoinPrice);
        System.out.println(cardanoPrice);
        System.out.println(ethereumPrice);

        client.shutdown();
    }
}

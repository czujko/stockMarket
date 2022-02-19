package com.ndynmate.stockmarket.controlador;

import com.ndynmate.stockmarket.CoinGeckoApiClient;
import com.ndynmate.stockmarket.CoinGeckoApiService;
import com.ndynmate.stockmarket.constant.Currency;
import com.ndynmate.stockmarket.impl.CoinGeckoApiClientImpl;
import com.ndynmate.stockmarket.modelo.CoinMarkets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class Inicio {

    @GetMapping("/usd")
    public String index(Model model) {
        CoinGeckoApiClient coinGeckoApiClient = new CoinGeckoApiClientImpl();
        List<CoinMarkets> coinMarket = coinGeckoApiClient.getCoinMarkets(Currency.USD);
        for (int i = 0; i < 10; i++) {
            log.info("id: {}", coinMarket.get(i).getImage());
            log.info("name: {}", coinMarket.get(i).getName());
            log.info("symbol: {}", coinMarket.get(i).getSymbol());
            log.info("currentPrice: {}", coinMarket.get(i).getCurrentPrice());
        }
        model.addAttribute("coinMarkets", coinMarket);
        return "usd";
    }

    @GetMapping("/euro")
    public String indexEUR(Model model) {
        CoinGeckoApiClient coinGeckoApiClient = new CoinGeckoApiClientImpl();
        List<CoinMarkets> coinMarket = coinGeckoApiClient.getCoinMarkets(Currency.EUR);
        for (int i = 0; i < 10; i++) {
            log.info("id: {}", coinMarket.get(i).getImage());
            log.info("name: {}", coinMarket.get(i).getName());
            log.info("symbol: {}", coinMarket.get(i).getSymbol());
            log.info("currentPrice: {}", coinMarket.get(i).getCurrentPrice());
        }
        model.addAttribute("coinMarkets", coinMarket);
        return "euro";
    }
}

package com.ndynmate.stockmarket.controlador;

import com.ndynmate.stockmarket.CoinGeckoApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class Inicio {
    @Autowired
    private CoinGeckoApiService coinGeckoApiService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ejecutando controlador inicio");
        var listaCrypto = coinGeckoApiService.getCoinList();
        model.addAttribute("listaCrypto", listaCrypto);
        System.out.println(listaCrypto);
        return "index";
    }
}

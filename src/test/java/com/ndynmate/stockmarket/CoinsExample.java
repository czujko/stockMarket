package com.ndynmate.stockmarket;


import com.ndynmate.stockmarket.constant.Currency;
import com.ndynmate.stockmarket.impl.CoinGeckoApiClientImpl;
import com.ndynmate.stockmarket.modelo.CoinFullData;
import com.ndynmate.stockmarket.modelo.CoinList;
import com.ndynmate.stockmarket.modelo.CoinMarkets;
import com.ndynmate.stockmarket.modelo.CoinTickerById;

import java.util.List;

public class CoinsExample {
    public static void main(String[] args) {
        CoinGeckoApiClient client = new CoinGeckoApiClientImpl();
/*

        List<CoinList> coinList = client.getCoinList();
        System.out.println(coinList);

        long totalCoins = coinList.size();
        System.out.println(totalCoins);
*/

        List<CoinMarkets> coinMarkets = client.getCoinMarkets(Currency.USD);
        // recorrer lista y mostrar image, id, name, symbol y price
        /*for (CoinMarkets coinMarket : coinMarkets) {
            System.out.println(coinMarket.getImage() + " "
                    + coinMarket.getId() + " "
                    + coinMarket.getName() + " "
                    + coinMarket.getSymbol() + " "
                    + coinMarket.getCurrentPrice());

        }*/
        // recorrer lista y mostrar image, id, name, symbol y price de las 10 primeras monedas
        for (int i = 0; i < 10; i++) {
            System.out.println(coinMarkets.get(i).getId() + " "
                    + coinMarkets.get(i).getName() + " "
                    + coinMarkets.get(i).getSymbol() + " "
                    + coinMarkets.get(i).getCurrentPrice());

        }
        System.out.println(coinMarkets);

        /*CoinFullData bitcoinInfo = client.getCoinById("bitcoin");
        System.out.println(bitcoinInfo);*/

        /*String genesisDate = bitcoinInfo.getGenesisDate();
        System.out.println(genesisDate);*/


        /*DeveloperData bitcoinDevData = bitcoinInfo.getDeveloperData();
        System.out.println(bitcoinDevData);

        long bitcoinGithubStars = bitcoinDevData.getStars();
        System.out.println(bitcoinGithubStars);*/

        /*CoinTickerById bitcoinTicker = client.getCoinTickerById("bitcoin");
        System.out.println(bitcoinTicker);*/

        /*CoinFullData omiseGoInfo = client.getCoinInfoByContractAddress(platform, OMGContract);
        System.out.println(omiseGoInfo);

        IcoData omiseGoIcoInfo = omiseGoInfo.getIcoData();
        String icoStartDate = omiseGoIcoInfo.getIcoStartDate();
        System.out.println(icoStartDate);*/

        client.shutdown();
    }
}

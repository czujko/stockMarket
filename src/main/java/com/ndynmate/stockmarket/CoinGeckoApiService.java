package com.ndynmate.stockmarket;


import com.ndynmate.stockmarket.modelo.CoinFullData;
import com.ndynmate.stockmarket.modelo.CoinList;
import com.ndynmate.stockmarket.modelo.CoinMarkets;
import com.ndynmate.stockmarket.modelo.CoinTickerById;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

@Service
@Controller
public interface CoinGeckoApiService {

    @GET("simple/price")
    Call<Map<String,Map<String, Double>>> getPrice(@Query("ids") String ids,
                                      @Query("vs_currencies") String vsCurrencies,
                                      @Query("include_market_cap") boolean includeMarketCap,
                                      @Query("include_24hr_vol") boolean include24hrVol,
                                      @Query("include_24hr_change") boolean include24hrChange,
                                      @Query("include_last_updated_at") boolean includeLastUpdatedAt);

    @GET("simple/token_price/{id}")
    Call<Map<String,Map<String, Double>>> getTokenPrice(@Path("id") String id, @Query("contract_addresses") String contractAddress,
                               @Query("vs_currencies") String vsCurrencies, @Query("include_market_cap") boolean includeMarketCap,
                               @Query("include_24hr_vol") boolean include24hrVol, @Query("include_24hr_change") boolean include24hrChange,
                               @Query("include_last_updated_at") boolean includeLastUpdatedAt);

    @GET("simple/supported_vs_currencies")
    Call<List<String>> getSupportedVsCurrencies();

    @GET("coins/list")
    Call<List<CoinList>> getCoinList();

    @GET("coins/markets")
    Call<List<CoinMarkets>> getCoinMarkets(@Query("vs_currency") String vsCurrency, @Query("ids") String ids,
                                           @Query("order") String order, @Query("per_page") Integer perPage,
                                           @Query("page") Integer page, @Query("sparkline") boolean sparkline,
                                           @Query("price_change_percentage") String priceChangePercentage);

    @GET("coins/{id}")
    Call<CoinFullData> getCoinById(@Path("id") String id, @Query("localization") boolean localization, @Query("tickers") boolean tickers,
                                   @Query("market_data") boolean marketData, @Query("community_data") boolean communityData,
                                   @Query("developer_data") boolean developerData, @Query("sparkline") boolean sparkline);

    @GET("coins/{id}/tickers")
    Call<CoinTickerById> getCoinTickerById(@Path("id") String id, @Query("exchange_ids") String exchangeIds,
                                           @Query("page") Integer page, @Query("order") String order);

}

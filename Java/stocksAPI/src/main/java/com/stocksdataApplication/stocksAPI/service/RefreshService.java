package com.stocksdataApplication.stocksAPI.service;

import com.stocksdataApplication.stocksAPI.model.StockWrapper;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class RefreshService {
    private final HashMap<StockWrapper, Boolean> stocksToRefresh;

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private static final Duration refreshPeriod = Duration.ofSeconds(15);

    public RefreshService(){
        stocksToRefresh = new HashMap<>();
        setRefreshEvery15Minutes();
    }

    public boolean shouldRefresh(final StockWrapper stock){
        if(!stocksToRefresh.containsKey(stock)){
            stocksToRefresh.put(stock, false);
            return true;
        }
        return stocksToRefresh.get(stock);
    }


    private void setRefreshEvery15Minutes(){
        scheduler.scheduleAtFixedRate(() -> stocksToRefresh.forEach((stock, value) -> {
            if( stock.getLastAccessed().isBefore(LocalDateTime.now().minus(refreshPeriod))){
                System.out.println("Setting Should Refresh " + stock.getStock().getSymbol());
                stocksToRefresh.remove(stock);
                stocksToRefresh.put(stock.withLastAccessed(LocalDateTime.now()), true);
            }
        }),0, 15, TimeUnit.SECONDS);
    }
}

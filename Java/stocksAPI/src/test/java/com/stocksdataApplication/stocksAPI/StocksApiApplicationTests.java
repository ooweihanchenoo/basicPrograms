package com.stocksdataApplication.stocksAPI;

import com.stocksdataApplication.stocksAPI.model.StockWrapper;
import com.stocksdataApplication.stocksAPI.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class StocksApiApplicationTests {

	@Autowired
	private StockService stockService;

	@Test
	void contextLoads() throws IOException {
		final StockWrapper stock = stockService.findStock("AAPL");
		System.out.println(stock.getStock());

		final BigDecimal price = stockService.findPrice(stock);
		System.out.println(price);

		final BigDecimal change = stockService.findLastChangePercent(stock);
		System.out.println(change);

		final BigDecimal mean200DayPercent = stockService.findLastChangePercent(stock);
		System.out.println("Mean 200 Day Percents: " + mean200DayPercent + "%");
	}

	@Test
	void multiple() throws IOException, InterruptedException{
		final List<StockWrapper> stocks = stockService.findStocks(Arrays.asList("NVDA", "TSLA", "GOOG"));
		findPrices(stocks);

		Thread.sleep(16000);
		final StockWrapper aa = stockService.findStock("NIO");
		stocks.add(aa);
		System.out.println(stockService.findPrice(aa));

		findPrices(stocks);
	}
	private void findPrices(List<StockWrapper> stocks){
		stocks.forEach(stock ->{
			try{
				System.out.println((stockService.findPrice(stock)));
			}
			catch (IOException e){

			}
		});
	}

}

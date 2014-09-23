package lesson35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.concurrent.Future;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class StockQuoteService {

    @Async
    public Future<Stock> getStockQuote(String symbol) throws InterruptedException {
        InputStream stream = null;
        try {
            stream = new URL("http://quote.yahoo.com/d/quotes.csv?s=" 
                    + symbol + "&f=sl1d1t1c1ohgv&e=.csv").openStream();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        String ticker = null, price = null;
        try (InputStreamReader inStream = new InputStreamReader(stream);
                BufferedReader buff = new BufferedReader(inStream);) {
            String csvString = buff.readLine();
            StringTokenizer tokenizer = new StringTokenizer(csvString, ",");
            ticker = tokenizer.nextToken();
            price = tokenizer.nextToken();
        } catch (MalformedURLException e) {
            System.out.println("Please check the spelling of " + "the URL: " + e.toString());
        } catch (IOException e1) {
            System.out.println("Can't read from the Internet: " + e1.toString());
        } finally {
            return new AsyncResult<>(new Stock(ticker, price));
        }
    }
}

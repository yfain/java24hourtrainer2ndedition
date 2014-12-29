package decoders;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/stockprice",
                encoders = {StockEncoder.class},
                decoders = {StockDecoder.class})
public class StockWebsocketEndpoint {
 
	@OnMessage
	public Stock getPriceQuote(Stock stock){

		stock.price =Math.random()*100;	
		return stock;
	}
}

package decoders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class StockEncoder implements Encoder.Text<Stock>{

	public void init(EndpointConfig config) {}

	public String encode(Stock stock) throws EncodeException {
        System.out.println("In Encoder: Serializing Stock object into String");
		return stock.symbol + ": " + stock.price;
	}

	public void destroy() {}
}

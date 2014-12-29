package decoders;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class StockDecoder implements Decoder.Text<Stock>{

	@Override
	public void init(EndpointConfig config) {}

	public Stock decode(String symbol) throws DecodeException {
		System.out.println("In Decoder: converting " + symbol + " into Stock object");
		Stock stock = new Stock();
		stock.symbol=symbol;      
		return stock;
	}

    public boolean willDecode(String symbol) {
        System.out.println("Allowing decoding");
	    return (symbol != null);
    }

	public void destroy() {}
}

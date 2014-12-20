package lesson33.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/stock")
public class StockService {
    
    @Produces({"application/xml","application/json"})
    @Path("{symbol}")
    @GET
    public Stock getStock(@PathParam("symbol") String symbol) {

        Stock stock = StockServiceHelper.getStock(symbol);

        if (stock == null) {
            return new Stock("NOT FOUND", 0.0, "--", "--");
        }

        return stock;
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public Response addStock(@FormParam("symbol") String symbol,
                             @FormParam("currency") String currency,
                             @FormParam("price") String price,
                             @FormParam("country") String country) {

        if (StockServiceHelper.getStock(symbol) != null)
            return Response.status(Response.Status.BAD_REQUEST).
                    entity("Stock " + symbol + " already exists").type("text/plain").build();

        double priceToUse;
        try {
            priceToUse = new Double(price);
        }
        catch (NumberFormatException e) {
            priceToUse = 0.0;
        }

        StockServiceHelper.addStock(new Stock(symbol, priceToUse, currency, country));

        return Response.ok().build();
    }
}

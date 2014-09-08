package lesson34.controller;

import lesson34.*;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
    	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView rootView(HttpServletResponse response) throws IOException{
            return new ModelAndView("home");
	}
	@RequestMapping(value="/quote", method = RequestMethod.GET)
	public @ResponseBody Stock rootView(@RequestParam(value = "symbol", required = false) String symbol, HttpServletResponse response) throws IOException, InterruptedException, ExecutionException{
            return new StockQuoteService().getStockQuote(symbol).get();
	}
}

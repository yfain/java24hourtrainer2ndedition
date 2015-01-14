package lesson35.controller;

import lesson35.Stock;
import lesson35.StockQuoteService;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainView(HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView("index");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        mv.addObject("currentUser", auth.getName());
        return mv;
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public @ResponseBody
    Stock quoteView(@RequestParam(value = "symbol", required = false) String symbol, HttpServletResponse response) throws IOException, InterruptedException, ExecutionException {
        return new StockQuoteService().getStockQuote(symbol).get();
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginView(HttpServletResponse response) throws IOException {
        return new ModelAndView("login");
    }
    
    @RequestMapping(value = "/hiddenpage", method = RequestMethod.GET)
    public String hiddenView(HttpServletResponse response) throws IOException {
        return "Hidden Page";
    }
}

package lesson31.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lesson31.ejb.HelloWorldBean;
import lesson31.ejb.HelloWorldLocal;
import lesson31.ejb.StockServerBean;

@WebServlet(urlPatterns = { "/HelloWorldServlet" })
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//@EJB HelloWorldBean myBean;
	@EJB StockServerBean myBean;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//out.println(myBean.sayHello());
		out.println(myBean.getQuote("AMZN"));
		
	}

}

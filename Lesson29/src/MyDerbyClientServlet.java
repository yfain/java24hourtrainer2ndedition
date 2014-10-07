

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/MyDerbyClientServlet")
public class MyDerbyClientServlet extends HttpServlet {

	@Resource(name="java:global/DerbyPool")
	DataSource ds; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
	 	    Connection myPooledConnection = ds.getConnection();
			System.out.println("Got pooled connection to DerbyDB");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}

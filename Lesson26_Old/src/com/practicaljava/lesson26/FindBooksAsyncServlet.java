package com.practicaljava.lesson26;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/booksasync"}, asyncSupported=true)
public class FindBooksAsyncServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException{

	// Don't send response when doGet ends
	AsyncContext aContext = request.startAsync();	

	  //Provide Runnable implementation to start method
	  aContext.start(() ->{
		
		// a blocking operation goes here
		try{
			String title = aContext.getRequest().getParameter("booktitle");

			PrintWriter out;
			try {
				Thread.currentThread().sleep(3000);  // Emulate a 3-second process

				HttpServletResponse resp = (HttpServletResponse) aContext.getResponse();
				out = resp.getWriter();
				out.println("Hello from Async FindBooks");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}catch( InterruptedException e){
			e.printStackTrace();
		}finally{
			aContext.complete(); // close the response obj			
		}
		
	  });
	
	}

}

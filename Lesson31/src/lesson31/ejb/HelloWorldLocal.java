package lesson31.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldLocal implements Authorizable {

     public String authorize(){
    	    return "The user is authorized!";
     }
     
     public String sayHello(){
         return "Hello World!";
     }
}

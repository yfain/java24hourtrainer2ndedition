
import java.lang.reflect.*;
public class ReflectionSample {
	
@SuppressWarnings("rawtypes")
public static void main(String args[]) {
     try {
       Class c = Class.forName("reflection.Employee");
       Method methods[] = c.getDeclaredMethods();
       System.out.println("The  Employee methods:");

       for (int i = 0; i < methods.length; i++){
            System.out.println("*** Method Signature:" + 
                                    methods[i].toString());
       }

       Class superClass = c.getSuperclass();
       System.out.println("The name of the superclass is " 
                                   + superClass.getName());

       Method superMethods[] = superClass.getDeclaredMethods();
       System.out.println("The superclass has:");

       for (int i = 0; i < superMethods.length; i++){
            System.out.println("*** Method Signature:" + 
                               superMethods[i].toString());
            System.out.println("      Return type: " + 
                superMethods[i].getReturnType().getName());
       }
       
       
       Class parameterTypes[]= new Class[] {String.class};
       
    @SuppressWarnings("unchecked")
	Method myMethod = c.getMethod( "changeAddress", parameterTypes);

       Object arguments[] = new Object[1];
       arguments[0] = "250 Broadway";
       myMethod.invoke(c.newInstance(),arguments);

       
       
       

     } catch (Exception e) {
           e.printStackTrace();
     }
  }
}

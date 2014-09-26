import java.time.LocalDateTime;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfDates {
   
  public static void main(String[] args){

 	// Implementing a Supplier interface
	Supplier<LocalDateTime> myStopWatch = () -> { 
           try{
    	       Thread.sleep(1000);
           } catch (InterruptedException e){
               e.printStackTrace();
    	   }
    	   return LocalDateTime.now(); // get the current time
    	   };
    	   
     // Generating a stream 	   
     Stream<LocalDateTime> timeStream = Stream.generate(myStopWatch); 	   
    	   
     timeStream.forEach(System.out::println);   	   
   }
}
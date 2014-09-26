import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;


public class ShortCircuit {

	    // Populate beer collection
	    static List<Beer> loadCellar(){
	        List<Beer> beerStock = new ArrayList<>();

	        beerStock.add(new Beer("Stella", "Belgium", 7.75f));
	        beerStock.add(new Beer("Sam Adams", "USA", 7.00f));
	        beerStock.add(new Beer("Obolon", "Ukraine", 4.00f));
	        beerStock.add(new Beer("Bud Light", "USA", 5.00f));
	        beerStock.add(new Beer("Yuengling", "USA", 5.50f));
	        beerStock.add(new Beer("Leffe Blonde", "Belgium", 8.75f));
	        beerStock.add(new Beer("Chimay Blue", "Belgium", 10.00f));
	        beerStock.add(new Beer("Brooklyn Lager", "USA", 8.25f));

	        return beerStock;
	    }

	    public static void main(String[] args) {

	        //List<Beer> beers = loadCellar();  // load the beer collection
	    	 List<Beer> beers = new ArrayList<>();
	        
	        
	        LongStream evenNumbers = LongStream
	        		.iterate(0, num -> num+2)
	        		.limit(5);
	        
	        evenNumbers.forEach(System.out::println);
	        
	        
	        
	        Optional<Beer> firstBeer = beers.stream()
	             .findFirst();
	          
	        //System.out.println("The first beer in collection: " + 
	          //   firstBeer.orElse(new Beer("No name","No country",0 )));
	        
	        System.out.println("The first beer in collection: " + 
		             firstBeer);
	        
	        
	        
		}
	}

	
	


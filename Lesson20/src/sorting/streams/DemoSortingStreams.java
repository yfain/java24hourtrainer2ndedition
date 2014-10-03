package sorting.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DemoSortingStreams{

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

        List<Beer> beers = loadCellar();  // load the beer collection
        
        
        
        System.out.println("=== Sorting stream by ascending price");
        		
        beers.stream()
        .sorted(Comparator.comparing(b -> b.price))
        .forEach(System.out::println);     
        
        System.out.println("=== Sorting stream by ascending price");
        System.out.println("=== with creating a new collection");
        
        List<Beer> sortedBeers = beers.stream()
        .sorted(Comparator.comparing(b -> b.price))
        .collect(Collectors.toList());
        
        sortedBeers.forEach(System.out::println); 
        
        
        System.out.println("=== Sorting stream by country and price");        
        beers.stream()
             .sorted(Comparator.comparing((Beer b) -> b.country)
            		 .thenComparing(b -> b.price))
             
             .forEach(System.out::println); 
        
        
        
	}
    
    
    
    
}

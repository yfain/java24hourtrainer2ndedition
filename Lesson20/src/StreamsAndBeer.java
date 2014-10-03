import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Demo of Streams API
 *
 * Created by yfain11 on 4/4/14.
 */

public class StreamsAndBeer {

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

        List<Beer> beers = loadCellar();                  // populate the beer collection
        List<Beer> preferredBeers = new ArrayList<>();    // I like Belgium beers
        List<Beer> americanBeers = new ArrayList<>();     // Some like American beers

        // External processing
/*        for(Beer beer: beers){
            if ("Belgium".equals(beer.country)) {
                preferredBeers.add(beer);
                System.out.println("Found a Belgium beer using external loop for: "+ beer.name);
            }
        }
*/
        // Internal processing with lambda
        beers.forEach(brr -> {
                if ("Belgium".equals(brr.country)){
                    preferredBeers.add(brr);
                    System.out.println("Found a Belgium beer using internal loop for: "+ brr.name);
                }
              });

        System.out.println("\nBeer names from preferredBeers collection - internal looping with forEach():");
        System.out.println("=====\n");

        preferredBeers.forEach(pbeer -> System.out.println("Preferred beer name: " + pbeer.name));

         System.out.println("=====  SAMPLES WITH STREAMS =====\n" );

        // Filtering streams
        americanBeers = beers.stream()                   // Turn a collection into a stream
                .filter(brr -> "USA".equals(brr.country))  // Intermediate operation: filter
                .collect(Collectors.toList());        // Terminal operation to convert a result into a new collection

        System.out.println("\nBeer names from americanBeers collection - applied filter country==USA ");
        System.out.println("=====\n");
        americanBeers.forEach(ambr -> System.out.println("American beer name: " + ambr.name));


        // Sorting  the stream

        // Function<Beer, Double> byPrice = b -> b.price;
        System.out.println("\nBeer sorted by price ");
        System.out.println("=====\n");
        beers.stream()
                .sorted(Comparator.comparing(b -> b.price))
                .forEach(System.out::println);

        

        // Filter, map, reduce
        OptionalDouble averagePrice = beers.stream()
                .filter(brr -> brr.country=="USA")
                .mapToDouble(brrr -> brrr.price)
                .average();        // Combining the results (reducing)

        System.out.println("\nApplied filter, map  reduce (average) ");
        System.out.println("=====");
        System.out.println("The average price of American beer is $" + averagePrice.getAsDouble());

        // Reusing lambdas with Predicate
        Predicate<Beer> madeInUSA = brr -> brr.country == "USA";

        americanBeers = beers.stream()          // Turn a collection into a stream
                .filter(madeInUSA)              // Intermediate operation filter
                .collect(Collectors.toList());  // Terminal operation to convert a result into a new collection

        System.out.println("\nBeer names from americanBeers collection - applied filter with predicate ");
        System.out.println("=====\n");
        americanBeers.forEach(ambr -> System.out.println("American beer name: " + ambr.name));

        americanBeers = beers.stream()
                .filter(StreamsAndBeer::isMadeInUSA)    // filter uses method reference
                .collect(Collectors.toList());

        System.out.println("\nBeer names from americanBeers collection - applied method reference StreamsAndBeer::isMadeInUSA ");
        System.out.println("=====\n");
        americanBeers.forEach(ambr -> System.out.println("American beer name: " + ambr.name));


    }

      private static boolean isMadeInUSA (Beer b){
        return b.country=="USA";
      }

}

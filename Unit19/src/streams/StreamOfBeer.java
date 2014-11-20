package streams;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class StreamOfBeer {

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


        // Filtering streams
        americanBeers = beers.stream()                // Turn a collection into a stream
                .filter(brr -> "USA".equals(brr.country))    // Intermediate operation filter
                .collect(Collectors.toList());        // Terminal operation to convert a result into a new collection

        System.out.println("\nBeer names from americanBeers collection - applied filter country==USA ");
        System.out.println("=====\n");
        americanBeers.forEach(ambr -> System.out.println("American beer name: " + ambr.name));

        // Sorting  the stream

        System.out.println("\nSorting beers by price ");
        System.out.println("=====\n");
        beers.parallelStream()
                .sorted(Comparator.comparing(b -> b.price))
                .forEachOrdered(System.out::println);


        // Filter, map, reduce
        OptionalDouble averagePrice = beers.stream()
                .filter(brr -> brr.country=="USA")
                .mapToDouble(brrr -> brrr.price)
                .average();        // Combining the results (reducing)

        System.out.println("\nApplied filter, map  reduce (average) ");
        System.out.println("=====\n");
        System.out.printf("The average beer price of the American beer is $%3.2f" ,
                                                               averagePrice.getAsDouble());


        // Reusing lambdas with Predicate
        Predicate<Beer> madeInUSA = brr -> "USA".equals(brr.country);

        americanBeers = beers.stream()
                .filter(madeInUSA)
                .collect(Collectors.toList());

        System.out.println("\nBeer names from americanBeers collection - applied filter with predicate ");
        System.out.println("=====\n");
        americanBeers.forEach(ambr -> System.out.println("American beer name: " + ambr.name));

        Predicate<Beer> cheap = beerrr -> beerrr.price < 7.00f;

        // Composition of madeInUSA and cheap predicate
        System.out.println("\n Cheap American beers:");
        beers.stream()
                .filter(madeInUSA.and(cheap))
                .forEach(System.out::println);

        /*
        System.out.println("\nAmerican beers: applied reference method StreamOfBeer::isMadeInUSA ");
        System.out.println("=====\n");
        // Filtering using method reference
        beers.stream()
             .filter(StreamOfBeer::isMadeInUSA)    // filter uses method reference
             .forEach(System.out::println);


 */
    }


    public static boolean isMadeInUSA (Beer b){
        return b.country=="USA";
    }

}

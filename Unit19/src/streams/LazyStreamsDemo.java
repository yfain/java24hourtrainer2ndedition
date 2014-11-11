package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Demo of intermediate operations and lazy processing in Stream API
 *
 * 1. Run this program as is - the intermediate operations don't read data
 * until the terminal operation is invoked
 *
 * 2. Uncomment the very print statement with the terminal operation
 * to see all outputs from intermediate operations.
 *
 * 3. Observe the lazy invocation of intermediate operations.
 *
 */

public class LazyStreamsDemo {

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

        List<Beer> beers = loadCellar();  // populate the beer collection

        // Filter, map, reduce with chaining
/*        OptionalDouble averagePrice = beers.stream()
                .filter(brr -> "USA".equals(brr.country))
                .mapToDouble(brrr -> brrr.price)
                .average();        // Combining the results (reducing)

        System.out.println("The average price of American beer is $" + averagePrice.getAsDouble());
*/
        // Filter, map, reduce without chaining
        Stream<Beer> americanBeers = beers.stream()
                .filter(brrsssss -> {System.out.println("Inside filter: " + brrsssss.country);
                    return "USA".equals(brrsssss.country);
                });

        DoubleStream americanBeerPrices = americanBeers
                .mapToDouble(brrr -> {System.out.println("Inside mapToDouble: "
                        + brrr.name + ": " + brrr.price);
                    return brrr.price ;
                });

        System.out.println("The average American beer price istember 22nd $" +
                americanBeerPrices.average().getAsDouble());
    }
}

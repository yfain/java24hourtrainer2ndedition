package predicate;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilteringBeerMethodReference {

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

        List<Beer> beers = loadCellar();   // populate the beer collection
        List<Beer> filteredBeers = new ArrayList<>();


        // Functional interface Predicate, method reference implementation
        // boolean test(T t)

        // Passing a function to a method as argument
        filterBeerCollection(beers, filteredBeers, FilteringBeerMethodReference::isFromBelgium);

        filterBeerCollection(beers, filteredBeers, FilteringBeerMethodReference::isExpensive);


    }

    private static boolean isFromBelgium(Beer beer) {
          return "Belgium".equals(beer.country);
    }

    private static boolean isExpensive(Beer beer) {
        return beer.price > 8.00f;
    }

    private static void filterBeerCollection (List<Beer> beers, List<Beer> filteredBeers,
                                              Predicate<Beer> condition){
        for(Beer beer: beers){
            if (condition.test(beer)) {
                filteredBeers.add(beer);
                System.out.println("In filterBeerCollection: "+ beer);
            }
        }
        System.out.println("==== filterBeerCollection is complete ");

    }
}

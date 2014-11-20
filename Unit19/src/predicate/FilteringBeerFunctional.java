package predicate;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilteringBeerFunctional {

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


        // Functional thinking with Predicate, lambda implementation
        // boolean test(T t)

        Predicate<Beer> fromBelgium = brr -> "Belgium".equals(brr.country);

        filterBeerCollection(beers, filteredBeers, fromBelgium);

        Predicate<Beer> expensive = brr -> brr.price > 8.00f;

        filterBeerCollection(beers, filteredBeers, expensive);

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

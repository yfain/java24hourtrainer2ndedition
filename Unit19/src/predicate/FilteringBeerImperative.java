package predicate;


import java.util.ArrayList;
import java.util.List;

public class FilteringBeerImperative {

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
        List<Beer> preferredBeers = new ArrayList<>();
        List<Beer> expensiveBeers = new ArrayList<>();

        // Imperative thinking

        findBelgiumBeers(beers, preferredBeers);

        findBeerByCountry(beers, preferredBeers, "Belgium");

        findExpensiveBeers(beers, expensiveBeers, 8.00f);
    }


    private static void findBelgiumBeers(List<Beer> beers, List<Beer> preferredBeers) {
        for(Beer beer: beers){
            if ("Belgium".equals(beer.country)) {
                preferredBeers.add(beer);
                System.out.println("In findBelgiumBeers: got Belgium beer: "+ beer.name);
            }
        }
    }

    private static void findBeerByCountry(List<Beer> beers, List<Beer> preferredBeers,
                                                                      String country) {
        for(Beer beer: beers){
            if (country.equals(beer.country)) {
                preferredBeers.add(beer);
                System.out.println("  In findBeerByCountry: got Belgium beer: "+ beer.name);
            }
        }
    }

    private static void findExpensiveBeers(List<Beer> beers, List<Beer> expensiveBeers,
                                                                       float minPrice) {

        for(Beer beer: beers){
            if (beer.price > minPrice) {
                expensiveBeers.add(beer);
                System.out.println("    In findExpensiveBeers: "+ beer.name + " costs " + beer.price);
            }
        }
    }
}

package sorting.comparable;

public class Beer implements Comparable<Beer>{
    public String name;
    public String country;
    public float price;

    Beer(String name, String country,float price){
        this.name=name;
        this.country=country;
        this.price=price;
    }

	public int compareTo(Beer otherBeer) {
		
		if (this.price > otherBeer.price){
			return 1;   // This beer is "larger" than the other one
		} else if (this.price < otherBeer.price) {
			return -1;  // This beer is "smaller" than the other one
		} else {
		    return 0;   // The beers are "equal"
		}    
	}
	
    public String toString(){
        return "Name: " + name + ", price: " + price;
    }
}

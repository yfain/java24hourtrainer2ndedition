package tryit;

public class BikeOrder {

	private String order = "";
	
	public String getOrder()
	{
		return order;
	}
	
	public void validateOrder(String bikeModel, int quantity)
			throws TooManyBikesException {

		if(("Roadmaster".equals(bikeModel) && (quantity < 10)) || 
	       ("Diamondblack".equals(bikeModel) && (quantity < 12)) ||	
	       ("Mongoose".equals(bikeModel) && (quantity < 17)) || 
	       ("Zesty Trail".equals(bikeModel) && (quantity < 20)))
		{
			order = "Order's valid: " + bikeModel + 
					": " + quantity;
		}
		else
		{
			throw new TooManyBikesException("Can't ship " + quantity + 
					 " " + bikeModel + " bikes.");
		}
		
	}
}

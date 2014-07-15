package firstsamples;

public interface Payable {
	default boolean increasePay(int percent){
		System.out.println(
		  "The default code implementing pay increase goes here");
		return true;
	};
	
	static double checkThePayIncreaseLimit(){
		// do something
		return 12345.00;
	}
}

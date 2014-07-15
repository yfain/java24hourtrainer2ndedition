package defendermethods;

public interface Payable {
	default public boolean increasePay(int percent){
		System.out.println(
		  "In Payable: increasePay()");
		return true;
	}
}

package defendermethods;

public interface Promotionable {
	default public boolean increasePay(int percent){
		System.out.println(
		  "In Promotionable: increasePay()");
		return true;
	};
}

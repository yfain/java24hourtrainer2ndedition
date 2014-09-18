package solution;

@FunctionalInterface
public interface Payable {
    int INCREASE_CAP = 20; 
	boolean increasePay(int percent);
}

package tax;

@FunctionalInterface
public interface TaxFunction {
	double calcTax(double grossIncome);
}

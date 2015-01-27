package tax;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaxExceptionTest {

	@Test(expected=IllegalArgumentException.class)
	public void testForNegativeGrossIncome() {
	  Tax tax = new Tax();

	  tax.calcTax(-100, 2);
	  fail("grossIncome in calcTax() can't be negative.");	
	}
}

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class test1 {

	@Test
	void test4() {
		RepaymentsCalculator.Results result = RepaymentsCalculator.calculator(new BigDecimal("10.0"), 4);
		Assert.assertTrue("expected not null",result != null);
		Assert.assertTrue("expected 2.50 got "+result.smallPayments,new BigDecimal("2.50").equals(result.smallPayments));
		Assert.assertTrue(result.lastPayment == null);
	}
	@Test
	void test2() {
		RepaymentsCalculator.Results result = RepaymentsCalculator.calculator(new BigDecimal("10.0"), 3);
		Assert.assertTrue("expected not null",result != null);
		Assert.assertTrue("expected 3.33 got "+result.smallPayments,new BigDecimal("3.33").equals(result.smallPayments));
		Assert.assertTrue("expected 3.34 got "+result.lastPayment,new BigDecimal("3.34").equals(result.lastPayment));
	}
	@Test
	void test3() {
		RepaymentsCalculator.Results result = RepaymentsCalculator.calculator(new BigDecimal("5444333222.00"), 1234);
		Assert.assertTrue("expected not null",result != null);
		Assert.assertTrue("expected 4411939.40 got "+result.smallPayments,new BigDecimal("4411939.40").equals(result.smallPayments));
		Assert.assertTrue("expected 4411941.80 got "+result.lastPayment,new BigDecimal("4411941.80").equals(result.lastPayment));
	}

}

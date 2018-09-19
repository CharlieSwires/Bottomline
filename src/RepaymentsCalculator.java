import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class RepaymentsCalculator {

	private static final int DECIMAL_PLACES = 2;
	private static final int MAX_PRECISION = 200;
	
	class Results {
		BigDecimal smallPayments;
		BigDecimal lastPayment;
		Results(){
		}
	}
	
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: RepaymentsCalculator <ammount> <num repayments>");
			System.exit(0);
		}
		Results result = calculator(new BigDecimal(args[0]), Integer.parseInt(args[1]));
		System.out.println("Regular Amount "+result.smallPayments);
		if (result.lastPayment != null) {
			System.out.println("Last Amount "+result.lastPayment);
		}
	}
	
	protected static Results calculator(BigDecimal totalToBePaid, int numberOfPayments) {
		BigDecimal part = (totalToBePaid.divide(new BigDecimal(numberOfPayments),new MathContext(MAX_PRECISION))).setScale(DECIMAL_PLACES,RoundingMode.HALF_UP);
		BigDecimal mostPart = part.multiply(new BigDecimal(numberOfPayments - 1));
		BigDecimal last = totalToBePaid.subtract(mostPart);
		Results result = new RepaymentsCalculator().new Results();
		result.smallPayments = part;
		if (last.equals(part)) {
			result.lastPayment = null;
		} else {
			result.lastPayment = last;
		}
		return result;
	}

}

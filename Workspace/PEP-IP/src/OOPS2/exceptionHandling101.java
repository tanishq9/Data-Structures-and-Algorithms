package OOPS2;

public class exceptionHandling101 {

	public static void main(String[] args) {
		int dividend = 0, divisor = 0;
		// custom error exception ko hamesha throw karna padhta hai
		try {
			System.out.println(dividend / divisor);
		} catch (ArithmeticException gne) {
			System.out.println("0/0 not allowed");
		}

		System.out.println("See even after some error, I am able to execute further statements");
		System.out.println("This is because we have caught(catch) the run time exception in main thread");
	}
}

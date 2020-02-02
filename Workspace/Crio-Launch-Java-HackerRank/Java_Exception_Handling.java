package Crio_Launch_HackerRank_Java;

public class Java_Exception_Handling {
	class MyCalculator {
		/*
		 * Create the method long power(int, int) here.
		 */
		long power(int n, int p) throws Exception {
			if (n == 0 && p == 0) {
				throw new Exception("n and p should not be zero.");
			} else if (n < 0 || p < 0) {
				throw new Exception("n or p should not be negative.");
			}
			return (long) Math.pow(n, p);
		}
	}
}

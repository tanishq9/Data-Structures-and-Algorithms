package RecursionClassics;

public class multiplyRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5, b = 4; // We have to find 5*4
		int i = a;
		System.out.println(multiply(i, a, b));
	}

	private static int multiply(int inc, int a, int b) {
		if (b == 1) {
			return a;
		}
		a = a + inc;
		return multiply(inc, a, b - 1);
	}
}

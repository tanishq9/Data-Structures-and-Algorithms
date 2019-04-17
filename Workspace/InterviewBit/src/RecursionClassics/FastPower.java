package RecursionClassics;

public class FastPower {

	public static void main(String[] args) {
		long a = 5;
		long b = 4;
		System.out.println('1'-48);
		System.out.println(fastPower(a, b));
	}

	private static long fastPower(long a, long b) {
		if (b == 0) {
			return 1;
		}
		if (b == 1) {
			return a;
		}
		long smallAns = fastPower(a, b / 2);
		smallAns = smallAns * smallAns;
		if ((b & 1) != 1) {
			return smallAns;
		} else {
			return a * smallAns;
		}
	}
}

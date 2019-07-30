package BitMasking;

public class bleak {

	private static int setBits(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}
		return count;
	}

	private static int isBleak(int n) {
		for (int i = 1; i < n; i++) {
			if (i + setBits(i) == n) {
				return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println(isBleak(n));
	}

}

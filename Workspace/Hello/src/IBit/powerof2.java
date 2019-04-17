package IBit;

public class powerof2 {
	public static int power(String A) {
		if (A.equals("0") || A.equals("1")) {
			return 0;
		}
		int n = 0;
		for (int i = 0; i < A.length(); i++) {
			n = n * 10 + A.charAt(i) - '0';
			System.out.println(n);
		}
		System.out.println(n);
		if ((n & (n - 1)) == 0) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		// power("82328890238928923982");
	}

}

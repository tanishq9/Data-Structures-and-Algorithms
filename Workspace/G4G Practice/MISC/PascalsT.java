package IBit;

public class PascalsT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int line = 0, i = 0;
		for (; line <= 3; line++) {
			for (i = 0; i <= line; i++) {
				System.out.print(binomialCoeff(line, i) + " ");
			}
			System.out.println();
		}
	}

	private static int binomialCoeff(int n, int k) {
		int res = 1;
		if (n - k < k) {
			k = n - k;
		}
		for (int i = 0; i < k; i++) {
			res *= (n - i);
			res /= (i + 1);
		}
		return res;
	}

}

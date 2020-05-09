
package Recursion;

public class printDecreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// pdi(5);
		pdis(6);
	}

	private static void pdi(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		pdi(n - 1);
		System.out.println(n);
	}

	private static void pdis(int n) {
		if (n == 0) {
			return;
		}
		if ((n & 1) == 1) {
			System.out.println(n);
		}
		pdis(n - 1);
		if ((n & 1) == 0) {
			System.out.println(n);
		}
	}

}

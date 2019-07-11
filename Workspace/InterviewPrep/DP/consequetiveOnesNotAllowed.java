package DP;

import java.util.Scanner;

public class consequetiveOnesNotAllowed {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int mod = (int) Math.pow(10, 9) + 7;
		while (t-- > 0) {
			int num = sc.nextInt();
			int countZeros = 1;// string ending with 0
			int countOnes = 1;// string ending with 1
			for (int i = 2; i <= num; i++) {
				int temp = countOnes;
				countOnes = countZeros % mod;
				countZeros = (countZeros % mod + temp % mod) % mod;
			}
			int ans = (countZeros % mod + countOnes % mod) % mod;
			System.out.println(ans);
		}
	}
}

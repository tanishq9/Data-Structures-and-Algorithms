package Crio_Launch_HackerRank_Java;

import java.util.Scanner;

public class Java_Loops {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int N = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 1; i <= 10; i++) {
			System.out.print(N + " x " + i + " = ");
			System.out.println(N * i);
		}

		scanner.close();
	}
}

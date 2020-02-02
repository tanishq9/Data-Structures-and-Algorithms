package Crio_Launch_HackerRank_Java;

import java.util.Scanner;

public class Java_2D_Array {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				int sum = 0;
				int topRow = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
				int middleRow = arr[i + 1][j + 1];
				int lastRow = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
				sum += (topRow + middleRow + lastRow);
				max = Math.max(max, sum);
			}
		}
		System.out.println(max);

		scanner.close();
	}
}

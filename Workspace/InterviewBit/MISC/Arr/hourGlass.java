package Arr;

import java.util.Scanner;

public class hourGlass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] array = new int[6][6];
		for (int y = 0; y < 6; y++) {
			for (int x = 0; x < 6; x++) {
				array[x][y] = sc.nextInt();
			}
		}
		int maxSum = -63;
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				int currentSum = hourSum(array, i, j);
				if (currentSum > maxSum) {
					maxSum = currentSum;
				}
			}
		}
		System.out.println(maxSum);
	}

	static int hourSum(int[][] arr, int i, int j) {
		return arr[i - 1][j - 1] + arr[i][j - 1] + arr[i + 1][j - 1] + arr[i][j] + arr[i - 1][j + 1] + arr[i][j + 1]
				+ arr[i + 1][j + 1];
	}
}

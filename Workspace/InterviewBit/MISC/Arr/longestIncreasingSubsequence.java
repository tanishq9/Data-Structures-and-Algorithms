package Arr;

public class longestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 10, 12, 9, 33, 44, 50, 25 };
		int[] lis = new int[arr.length];
		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (arr[i] > arr[j]) {
					if (lis[i] < (lis[j] + 1)) {
						lis[i] = lis[j] + 1;
					}
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(lis[i] + " ");
		}
	}

}

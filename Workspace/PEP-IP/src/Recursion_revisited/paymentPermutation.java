package Recursion_revisited;

public class paymentPermutation {
	// order does not matter

	static int count = 0;

	static void permute(int[] arr, int target) {
		int currSum = 0;
		permuteHelper(arr, target, "", currSum);
		System.out.println(count);
	}

	static void permuteHelper(int[] arr, int target, String asf, int currSum) {
		if (currSum == target) {
			System.out.println(asf);
			count++;
		}
		if (currSum > target) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			permuteHelper(arr, target, asf + "" + arr[i], currSum + arr[i]);
		}
	}

	public static void main(String[] args) {
		int[] coins = { 2, 3, 5, 6 };
		int target = 10;
		permute(coins, target);
	}
}

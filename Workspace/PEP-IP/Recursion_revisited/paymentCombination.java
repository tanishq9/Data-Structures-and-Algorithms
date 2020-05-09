package Recursion_revisited;

public class paymentCombination {
	static int count = 0;

	static void permute(int[] arr, int target) {
		int currSum = target;
		permuteHelper(arr, target, currSum, "", 0);
		System.out.println(count);
	}

	static void permuteHelper(int[] arr, int target, int currSum, String asf, int startIndex) {
		if (currSum == 0) {
			System.out.println(asf);
			count++;
		}

		// reactive
		if (currSum < 0) {
			return;
		}

		for (int i = startIndex; i < arr.length; i++) {
			permuteHelper(arr, target, currSum - arr[i], asf + "" + arr[i], i);
		}
	}

	public static void main(String[] args) {
		int[] coins = { 2, 3, 5, 6 };
		int target = 10;
		permute(coins, target);
	}
}

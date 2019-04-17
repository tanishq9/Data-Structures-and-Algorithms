package DP;

public class targetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 5, 6, 1 };
		int targetSum = 7;
		System.out.println(isSumPossible(arr, 0, 0, targetSum));
	}

	private static boolean isSumPossible(int[] arr, int currentIndex, int currentSum, int targetSum) {
		if (currentIndex > targetSum) {
			return false;
		}
		if (currentSum == targetSum) {
			return true;
		}
		boolean consider = isSumPossible(arr, currentSum, currentIndex + 1, targetSum);
		boolean notConsider = isSumPossible(arr, currentSum + arr[currentIndex], currentIndex + 1, targetSum);
		if (consider || notConsider) {
			return true;
		}
		return false;
	}

}

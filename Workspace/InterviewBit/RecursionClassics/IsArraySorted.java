package RecursionClassics;

public class IsArraySorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 1, 2, 3, 4, 6 };
		System.out.println(isSorted(arr, 0));
	}

	private static boolean isSorted(int[] arr, int currentIndex) {

		// Base Case :
		if (currentIndex == arr.length - 1) {
			return true;
		}

		if (arr[currentIndex] <= arr[currentIndex + 1] && isSorted(arr, currentIndex + 1)) {
			return true;
		} else {
			return false;
		}
	}
}

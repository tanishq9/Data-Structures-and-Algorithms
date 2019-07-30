package Recursion;

public class floorInSortedArr {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 6, 10, 12, 14 };
		int larsmallest = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > larsmallest && arr[i] < 7) {
				larsmallest = arr[i];
			}
		}
		System.out.println(larsmallest);
	}

}

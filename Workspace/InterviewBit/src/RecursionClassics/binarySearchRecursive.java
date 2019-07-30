package RecursionClassics;

public class binarySearchRecursive {

	private static int bsearch(int[] arr, int s, int e, int element) {
		if (s > e) {
			return -1;
		}
		int mid = (s + e) / 2;
		if (arr[mid] == element) {
			return mid;
		} else if (arr[mid] > element) {
			return bsearch(arr, s, mid, element);
		} else {
			return bsearch(arr, mid, e, element);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 7 };
		System.out.println(bsearch(arr, 0, arr.length - 1, 5));
	}

}

package Recursion;

public class countInversions {

	public static int countInversions(int[] arr, int low, int high) {
		int total = 0;
		int mid = 0;
		if (low < high) {
			total = 0;
			mid = (low + high) / 2;
			total = countInversions(arr, low, mid) + countInversions(arr, mid + 1, high);
			total += crossInversions(arr, low, mid + 1, high);
		}
		return total;
	}

	private static int crossInversions(int[] arr, int low, int mid, int high) {
		int i = low;
		int j = mid; // starting of the second array
		int[] temp = new int[(high - low + 1)];
		int k = 0, count = 0;
		while (i < mid && j <= high) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else if (arr[i] > arr[j]) {
				count += (mid - i);
				temp[k++] = arr[j++];
			}
		}
		while (i < mid) {
			temp[k++] = arr[i++];
		}
		while (j <= high) {
			temp[k++] = arr[j++];
		}
		for (i = low; i <= high; i++) {
			arr[i] = temp[i - low];
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 1, 3, 4 };
		System.out.println(countInversions(arr, 0, arr.length - 1));
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}

package Array;

public class sort012 {
	public void sortColors(int[] arr) {
		int low = 0, mid = 0, high = arr.length - 1;
		// low ke pehle saare 0s hai
		// high ke baad saare 2s hai
		// mid ensures that the above 2 things are true
		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				swap(arr, mid, low);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr, mid, high);
				high--;
				break;
			}
		}
	}

	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

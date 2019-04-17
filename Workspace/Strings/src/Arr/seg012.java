package Arr;

public class seg012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 0, 1, 0, 2, 0, 1, 2, 0 };
		int low = 0, mid = 0, high = arr.length - 1, temp;
		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				mid++;
				low++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] = temp;
				high--;
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}

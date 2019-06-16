package SAPLabs;

public class secondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
		int arr[] = { 12, 34, 1, 10, 33, 38 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > first) {
				second = first;
				first = arr[i];
			}
			if (arr[i] > second && arr[i] < first) {
				second = arr[i];
			}
		}
		System.out.println(first + " " + second);
	}

}

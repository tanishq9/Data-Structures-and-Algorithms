package Arr;

public class numSwapsInBubble {

	public static void main(String[] args) {
		int[] arr = { 6, 4, 1, 5 };
		int swaps = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swaps++;
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
			if (swaps == 0) {
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(swaps);
	}

}

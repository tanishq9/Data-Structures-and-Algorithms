package Adobe;

import java.util.ArrayList;

public class WaveArray {

	public static void main(String[] args) {
		int[] arr = { 1, 9, 2, 3, 4, 5 };
		ArrayList<Integer> l = new ArrayList<>();
		ArrayList<Integer> p = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			l.add(i);
		}
		System.out.println(p);
		System.out.println(l.containsAll(p)); // does not take into account the ordering

		for (int i = 0; i < arr.length; i += 2) {
			if (i >= 1 && arr[i] < arr[i - 1]) {
				swap(arr, i, i - 1);
			}
			if (i <= (arr.length - 2) && arr[i] < arr[i + 1]) {
				swap(arr, i, i + 1);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			// System.out.print(arr[i] + " ");
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}

package Adobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaveArrayLexicographicallySmallest {

	public static void main(String[] args) {
		int[] arr = { 1, 9, 2, 3, 4, 5 };
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i += 2) {
			swap(arr, i, i + 1);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		ArrayList<Integer> l = new ArrayList<>();
		Collections.sort(l);

	}

}

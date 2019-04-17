package asort;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = { 4, 1, 2, 9, 6, 5, 0 };
		myCmp cmp = new myCmp();
		for (int i = 0; i < arr.length - 1; i++) {
			if (cmp.compare(arr[i], arr[i + 1]) > 0) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
	}
}

class myCmp implements Comparator<Integer> {
	public int compare(Integer o1, Integer o2) {
		// System.out.println(o1 + " " + o2);
		if (o1 > o2) {
			return 1;
		}
		return -1;
	}
}

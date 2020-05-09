package IBit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class largestNum {

	static class myC implements Comparator<String> {
		public int compare(String a, String b) {
			String ab = a + b;
			String ba = b + a;
			if (ab.compareTo(ba) > 0) {
				return -1;
			} else if (ab.compareTo(ba) < 0) {
				return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 0, 0, 0, 0, 0 };
		int countZ = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				countZ += 1;
			}
		}
		if (countZ == arr.length) {
			System.out.println("0");
		}
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(String.valueOf(arr[i]));
		}

		list.sort(new myC());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(list.get(i));
		}
		System.out.println(sb.toString());
	}
}

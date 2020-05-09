package HS;

import java.util.HashMap;

public class validPair {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 0 };
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				map.put(arr[i] + arr[j], 1);
			}
		}
		int m = 3;
		int k = 9;// m % k == 0
		Boolean flag = false;
		for (int i : map.keySet()) {
			if ((i % k) == m) {
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("False");
		} else {
			System.out.println("True");
		}
	}

}

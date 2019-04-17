package Arr;

import java.util.HashMap;
import java.util.Scanner;

public class pickingNumbers {
	static int pickingNumbers(int[] arr) {
		HashMap<Pair, Integer> map = new HashMap<>();
		int s = 0, e = arr.length - 1;
		int mid = (s + e) / 2;
		int ss = mid + 1;
		int count = 0;
		Integer one = new Integer(1);
		while (s <= mid && ss <= e) {
			if (Math.abs(arr[s] - arr[e]) == 1) {
				System.out.println(arr[s] + " " + arr[e]);
				count++;
				map.put(new Pair(arr[s], arr[e]), one);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(pickingNumbers(arr));
	}

}

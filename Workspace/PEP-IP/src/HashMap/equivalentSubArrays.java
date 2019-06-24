package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class equivalentSubArrays {
	public static int val(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int k = map.size();
		map = new HashMap<>();
		int start = 0;
		int end = 0;
		int count = 0;
		int n = arr.length - 1;
		boolean valid = false;
		while (end < arr.length) {
			map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
			if (map.size() == k) {
				valid = true;
			}
			while (valid == true) {
				map.put(arr[start], map.get(arr[start]) - 1);
				if (map.get(arr[start]) == 0) {
					map.remove(arr[start]);
					valid = false;
				}
				System.out.println(n - end + 1);
				count = count + (n - end + 1);
				start++;
			}
			end++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(val(arr));
	}
}

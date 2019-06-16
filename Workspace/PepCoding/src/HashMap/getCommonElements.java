package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class getCommonElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "hello";
		int[] one = { 5, 1, 3, 2, 2, 1, 2 };
		int[] two = { 1, 4, 1, 2, 2, 1, 5 };
		lfc(word);
		getCommonElements(one, two);
		getIntersectionElements(one, two);
		int[] consequetiveElements = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		largestConseqElements(consequetiveElements);
		largestConseqElementsON(consequetiveElements);
		int[] ksum = { 2, 5, 7, 9, -6, 8, 2, 15, 7, 3, 12 };
		kmultiple(ksum, 3);
	}

	private static void lfc(String word) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			char cc = word.charAt(i);
			if (map.containsKey(cc)) {
				map.put(cc, map.get(cc) + 1);
			} else {
				map.put(cc, 1);
			}
		}
		char lfchar = word.charAt(0);
		int lf = 1;
		ArrayList<Character> list = new ArrayList<>(map.keySet());
		// Instead of this range loop , the above list can also be used
		for (Character key : map.keySet()) {
			if (map.get(key) > lf) {
				lf = map.get(key);
				lfchar = key;
			}
		}
		System.out.println(lfchar + " " + lf);
	}

	public static void getCommonElements(int[] one, int[] two) {
		HashMap<Integer, Integer> onemap = new HashMap<>();
		HashMap<Integer, Integer> twomap = new HashMap<>();

		// Can be done using one map also
		// Build map for one array, iterate over other array and
		// check for occurrence of elements in array 2 in map
		// Erase if key found in array 2

		for (int i = 0; i < one.length; i++) {
			int currentElement = one[i];
			if (onemap.containsKey(currentElement)) {
				onemap.put(currentElement, onemap.get(currentElement) + 1);
			} else {
				onemap.put(currentElement, 1);
			}
		}
		for (int i = 0; i < two.length; i++) {
			int currentElement = two[i];
			if (twomap.containsKey(currentElement)) {
				twomap.put(currentElement, twomap.get(currentElement) + 1);
			} else {
				twomap.put(currentElement, 1);
			}
		}

		for (Integer keyone : onemap.keySet()) {
			for (Integer keytwo : twomap.keySet()) {
				if (keytwo == keyone) {
					System.out.print(keyone + " ");
				}
			}
		}
		System.out.println();
	}

	public static void getIntersectionElements(int[] one, int[] two) {
		HashMap<Integer, Integer> onemap = new HashMap<>();
		HashMap<Integer, Integer> twomap = new HashMap<>();

		// Can be done using one map also
		// Build map for one array, iterate over other array and
		// check for occurrence of elements in array 2 in map
		// Decrease frequency of key if found in array 2

		for (int i = 0; i < one.length; i++) {
			int currentElement = one[i];
			if (onemap.containsKey(currentElement)) {
				onemap.put(currentElement, onemap.get(currentElement) + 1);
			} else {
				onemap.put(currentElement, 1);
			}
		}
		for (int i = 0; i < two.length; i++) {
			int currentElement = two[i];
			if (twomap.containsKey(currentElement)) {
				twomap.put(currentElement, twomap.get(currentElement) + 1);
			} else {
				twomap.put(currentElement, 1);
			}
		}

		for (Integer keyone : onemap.keySet()) {
			for (Integer keytwo : twomap.keySet()) {
				if (keytwo == keyone) {
					int freq = Math.min(onemap.get(keyone), twomap.get(keytwo));
					while (freq-- > 0) {
						System.out.print(keyone + " ");
					}
				}
			}
		}
		System.out.println();
	}

	public static void largestConseqElements(int[] arr) {
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			hmap.put(arr[i], 1);
		}
		ArrayList<Integer> list = null;
		ArrayList<Integer> result = null;
		int maxLength = Integer.MIN_VALUE;
		// Doesn't work in 0(n), other approach works in O(n) given below
		for (int i = 0; i < arr.length; i++) {
			int currentElement = arr[i];
			int currentLength = 1;
			list = new ArrayList<>();
			list.add(currentElement);
			// Bad Approach : Works in 0(N): So,total is O(N^2) for code
			while (hmap.containsKey(currentElement - 1)) {
				list.add(currentElement - 1);
				currentLength += 1;
				currentElement -= 1;
			}
			if (currentLength > maxLength) {
				maxLength = currentLength;
				result = new ArrayList<>();
				result.addAll(list);
			}
		}
		System.out.println(maxLength);
		System.out.println(result);
	}

	public static void largestConseqElementsON(int[] arr) {
		HashMap<Integer, Boolean> hmap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			hmap.put(arr[i], true);
		}
		// Check if its a starting point
		for (int i = 0; i < arr.length; i++) {
			if (hmap.containsKey(arr[i] - 1)) {
				hmap.put(arr[i], false);
			}
		}
		ArrayList<Integer> list = null;
		ArrayList<Integer> result = null;
		int maxLength = Integer.MIN_VALUE;
		// Works in O(2*n)
		for (int i = 0; i < arr.length; i++) {
			int currentElement = arr[i];
			int currentLength = 1;
			list = new ArrayList<>();
			list.add(currentElement);
			while (hmap.containsKey(currentElement + 1)) {
				list.add(currentElement + 1);
				currentLength += 1;
				currentElement += 1;
			}
			if (currentLength > maxLength) {
				maxLength = currentLength;
				result = new ArrayList<>();
				result.addAll(list);
			}
		}
		System.out.println(maxLength);
		System.out.println(result);
	}

	static class Pair {
		int sp;
		int ep;

		Pair(int isp, int iep) {
			this.sp = isp;
			this.ep = iep;
		}
	}

	public static void kmultiple(int[] arr, int k) {

		int[] presum = new int[arr.length];
		presum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			presum[i] = arr[i] + presum[i - 1];
		}
		for (int i = 0; i < arr.length; i++) {
			presum[i] %= k;
		}
		for (int i = 0; i < presum.length; i++) {
			System.out.print(presum[i] + " ");
		}
		System.out.println();

		HashMap<Integer, Pair> map = new HashMap<>();
		int osp = -1;
		int oep = -2; // because answer is (oe_p-os_p+1) and if I get 0 length
		// then 1 will be returned but I want 0 to be returned, that is why
		// -2-(-1)+1 = 0
		for (int i = 0; i < k; i++) {
			if (i == 0) {
				map.put(i, new Pair(0, Integer.MIN_VALUE));
			} else {
				map.put(i, new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE));
			}
		}
		// Update the starting and ending points for each remainder
		for (int i = 0; i < presum.length; i++) {
			int key = presum[i];
			Pair value = map.get(key);
			if (value.sp == Integer.MIN_VALUE) {
				value.sp = i + 1;
			} else {
				value.ep = i;

			}
			if (oep - osp > value.ep - value.sp) {
				oep = value.ep;
				osp = value.sp;
			}
		}

		for (Integer p : map.keySet()) {
			Pair value = map.get(p);
			int sp = value.sp;
			int ep = value.ep;
			System.out.println(p + "->" + sp + "," + ep);
		}

	}

}

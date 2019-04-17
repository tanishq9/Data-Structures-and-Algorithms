package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class EqualPairSumUnsorted {

	static class Pair {
		int first;
		int second;

		Pair(int ifirst, int isecond) {
			first = ifirst;
			second = isecond;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 6, 4, 12, 10, 22, 54, 32, 42, 21, 11 };
		HashMap<Pair, Integer> map = new HashMap<Pair, Integer>();
		// Create map of pair and their sum
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				Pair pair = new Pair(arr[i], arr[j]);
				map.put(pair, arr[i] + arr[j]);
			}
		}
		// Create map of sum of corresponding pairs having that sum
		HashMap<Integer, ArrayList<Pair>> hmap = new HashMap<>();
		for (Pair p : map.keySet()) {
			int sum = map.get(p);
			if (!hmap.containsKey(sum)) {
				hmap.put(sum, new ArrayList<Pair>());
			}
			hmap.get(sum).add(p);
		}
		for (int i : hmap.keySet()) {
			System.out.print(i + " -> ");
			for (Pair p : hmap.get(i)) {
				System.out.print("(" + p.first + "," + p.second + ")" + ",");
			}
			System.out.println("END");
		}
	}

}

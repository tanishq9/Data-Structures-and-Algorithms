package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class groupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		if (strs.length == 0)
			return new ArrayList();

		// O(n*log(n)) : To maintain lexographical order
		Arrays.sort(strs);
		// O(n)
		for (String str : strs) {
			String key = "";
			int[] freq = new int[256];
			// O(k)
			for (int i = 0; i < str.length(); i++) {
				freq[str.charAt(i)] += 1;
			}
			// Build the key from frequency map
			for (int i = 0; i < 256; i++) {
				key += (freq[i] + "#");
			}
			// Search then add/update the map
			if (map.containsKey(key)) {
				List<String> list = map.get(key);
				list.add(str);
				map.put(key, list);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(key, list);
			}
		}
		List<List<String>> result = new ArrayList<>();
		for (String key : map.keySet()) {
			result.add(map.get(key));
		}
		return result;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Length of the array
		int N = sc.nextInt();

		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}

		List<List<String>> anagramsGrouped = groupAnagrams(arr);

		for (List<String> lst : anagramsGrouped) {
			Collections.sort(lst);
		}

		anagramsGrouped.sort(new ListComparator());

		display(anagramsGrouped);

	}

	// Comparator for sorting the result list.
	static class ListComparator implements Comparator<List<String>> {

		@Override
		public int compare(List<String> l1, List<String> l2) {

			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			for (int i = 0; i < l1.size(); i++) {
				String l1str = l1.get(i);
				String l2str = l2.get(i);

				return l1str.compareTo(l2str);

			}

			return 0;

		}
	}

	// Function to display a List of Lists of strings.
	public static void display(List<List<String>> list) {

		for (int i = 0; i < list.size(); i++) {

			List<String> currList = list.get(i);

			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}

			System.out.println();
		}

	}

}

package RecursionClassics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class subsequence2DList {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		A.add(16);
		A.add(17);
		A.add(7);
		A.add(3);
		A.add(6);
		A.add(18);
		A.add(5);
		A.add(13);
		A.add(14);
		Collections.sort(A);
		ArrayList<ArrayList<Integer>> l = subsets(A);
		for (ArrayList<Integer> list : l) {
			System.out.println(list);
		}
	}

	static class CustomComparator1 implements Comparator<ArrayList<Integer>> {
		public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
			if (!l1.isEmpty() && !l2.isEmpty()) {
				if (l1.get(0) <= l2.get(0)) {
					return -1;
				} else if (l1.get(0) > l2.get(0)) {
					return 1;
				} 
			}
			return 0;
		}
	}

	static class CustomComparator2 implements Comparator<ArrayList<Integer>> {
		public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
			if (!l1.isEmpty() && !l2.isEmpty()) {
				if (l1.get(0) == l2.get(0)) {
					if (l1.size() < l2.size()) {
						return -1;
					} else {
						return 1;
					}
				}
			}
			return 0;
		}
	}

	static ArrayList<ArrayList<Integer>> list = null;

	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		list = new ArrayList<ArrayList<Integer>>();
		gen(A, 0, new ArrayList<>());
		return list;
	}

	private static void gen(ArrayList<Integer> A, int i, ArrayList<Integer> temp) {
		if (i >= A.size()) {
			// Add List
			list.add((ArrayList<Integer>) temp.clone()); // Most Important step , otherwise copy would be created
			return;
		}
		// Ignore the current index.
		gen(A, i + 1, temp);
		// Include the current index.
		temp.add(A.get(i));
		gen(A, i + 1, temp);
		temp.remove(temp.size() - 1);
	}
}

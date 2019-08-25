package IBit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class maxDistance {
	static class Pair {
		int first;
		int second;

		Pair(int ifir, int isec) {
			first = ifir;
			second = isec;
		}
	}

	static class myC implements Comparator<Pair> {
		public int compare(Pair one, Pair two) {
			if (one.first < two.first) {
				return -1;
			} else if (one.first > two.first) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static int maximumGap(final List<Integer> A) {
		ArrayList<Pair> list = new ArrayList<>();
		if (A.size() == 1) {
			return 0;
		}
		for (int i = 0; i < A.size(); i++) {
			Pair p = new Pair(A.get(i), i);
			list.add(p);
		}
		list.sort(new myC());
		int max_diff = 0;
		int len = list.size();
		int max_index = list.get(len - 1).second;
		for (int i = len - 2; i >= 0; i--) {
			max_diff = Math.max(max_diff, max_index - list.get(i).second);
			max_index = Math.max(max_index, list.get(i).second);
		}
		return max_diff;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-1);
		list.add(-1);
		list.add(2);
		System.out.println(maximumGap(list));
	}

}

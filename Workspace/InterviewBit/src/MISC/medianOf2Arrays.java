package IBit;

import java.util.ArrayList;
import java.util.List;

public class medianOf2Arrays {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append('a');
		sb.reverse();

		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		l1.add(-50);
		/*l1.add(-41);
		l1.add(-40);
		l1.add(-19);
		l1.add(5);
		l1.add(21);
		l1.add(28);*/
		// [ -50, -41, -40, -19, 5, 21, 28 ]
		/*l2.add(-50);
		l2.add(-21);
		l2.add(-10);*/
		System.out.println(findMedianSortedArrays(l1, l2));
	}

	public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		int i = 0, j = 0, n = 0;
		List<Double> res = new ArrayList<>();
		while (i < a.size() && j < b.size()) {
			if (a.get(i) > b.get(j)) {
				res.add((double) b.get(j++));
			} else {
				res.add((double) a.get(i++));
			}
		}
		while (i < a.size()) {
			res.add((double) a.get(i++));
		}
		while (j < b.size()) {
			res.add((double) b.get(j++));
		}
		System.out.println(res);
		int desired = a.size() + b.size();
		// System.out.println(desired);
		if ((desired % 2) == 1) {
			System.out.println("odd");
			return res.get(desired / 2);
		} else {
			return (res.get(desired / 2) + res.get((desired / 2) - 1)) / 2;
		}
	}

}

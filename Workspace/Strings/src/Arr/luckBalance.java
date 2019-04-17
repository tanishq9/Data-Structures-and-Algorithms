package Arr;

import java.util.*;

class Pair {
	int data;
	int isImportant;

	Pair(int d, int isI) {
		this.data = d;
		this.isImportant = isI;
	}
}

class CustomComparator implements Comparator<Pair> {

	@Override
	public int compare(Pair o1, Pair o2) {
		// Return negative if you want o1 to come before o2
		// Return 0 if both can come in either order
		// Return positive if o1 should appear second
		if (o1.isImportant == 0 && o2.isImportant == 1) {
			return -1;
		} else if (o1.isImportant == 1 && o2.isImportant == 0) {
			return 1;
		} else if (o1.isImportant == 0 && o2.isImportant == 0) {
			return -1;
		} else if (o1.isImportant == 1 && o2.isImportant == 1) {
			if (o1.data > o2.data) {
				return -1;
			}
		}
		return 1;
	}
}

public class luckBalance {

	public static void main(String[] args) {
		int[][] arr = { { 10, 0 }, { 5, 0 }, { 6, 1 }, { 1, 1 }, { 5, 1 }, { 2, 1 } };
		ArrayList<Pair> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			Pair pair = new Pair(arr[i][0], arr[i][1]);
			list.add(pair);
		}
		list.sort(new CustomComparator());
		long sum = 0;
		int k = 5;
		for (Pair p : list) {
			System.out.println(p.data + " ");
			if (p.isImportant == 0) {
				sum += p.data;
			} else if (p.isImportant == 1) {
				if (k > 0) {
					sum += p.data;
					k--;
				}
			}
		}
		System.out.println(sum);
	}

}

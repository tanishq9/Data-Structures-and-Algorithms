package Recursion;

import java.util.ArrayList;
import java.util.HashSet;

public class subsetSum {

	static ArrayList<ArrayList<Integer>> result = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 4, 6, 8 };
		int sum = 8;
		ArrayList<Integer> l = new ArrayList<>();
		l.add(2);
		l.add(3);
		ArrayList<Integer> p = new ArrayList<>();
		p.add(2);
		p.add(3);
		HashSet<Integer> hs = new HashSet<>();
		hs.add(2131232);
		for (int i : hs) {
			System.out.println(i);
		}
		System.out.println(l.equals(p));
		result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<>();
		subsets(arr, sum, 0, list);
		System.out.println(result);
	}

	private static void subsets(int[] arr, int sum, int li, ArrayList<Integer> list) {
		if (sum == 0) {
			result.add((ArrayList<Integer>) list.clone());
			return;
		}
		for (int i = li; i < arr.length; i++) {
			if ((sum - arr[i]) >= 0) {
				list.add(arr[i]);
				subsets(arr, sum - arr[i], i, list);
				list.remove(list.size() - 1);
			}
		}
	}

}

package Arr;

import java.util.ArrayList;
import java.util.List;

public class printLongestLIS {

	public static void main(String[] args) {
		int arr[] = { 2, 6, 4, 5, 1, 3 };
		List<List<Integer>> list = new ArrayList<List<Integer>>(arr.length);
		// Also initialize each index of the list
		for (int i = 0; i < arr.length; i++) {
			list.add(new ArrayList<Integer>());
		}
		System.out.println(list.size());
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (arr[i] > arr[j] && list.get(i).size() < (list.get(j).size() + 1)) {
					if (!list.get(i).isEmpty()) {
						list.get(i).clear();
						list.get(i).addAll(list.get(j));
					} else if (list.get(i).isEmpty()) {
						list.get(i).addAll(list.get(j));
					}
				}
			}
			list.get(i).add(arr[i]);
		}
		int max = 0;
		List<Integer> lsi = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).size() > max) {
				max = list.get(i).size();
				lsi = list.get(i);
			}
		}
		System.out.println(lsi);
	}

}

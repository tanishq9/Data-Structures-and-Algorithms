package HashMap;

import java.util.HashSet;

public class findDistinctElementsInMatrixRows {
	public static int count(int[][] arr) {
		// Write your code here
		int n = arr.length;
		HashSet<Integer> set1 = new HashSet<>(); // Common set
		HashSet<Integer> set2 = new HashSet<>(); // Other set for consideration
		HashSet<Integer> temp = new HashSet<>(); // Use for transferring common elements

		// Init set1
		for (int j = 0; j < n; j++) {
			set1.add(arr[0][j]);
		}
		// Init set2
		for (int i = 1; i < n; i++) {
			set2.clear();
			for (int j = 0; j < n; j++) {
				set2.add(arr[i][j]);
			}
			for (int ele : set1) {
				if (set2.contains(ele)) {
					temp.add(ele);
				}
			}
			set1.clear();
			set1.addAll(temp);
			temp.clear();
		}
		return set1.size();
	}
}

package IBit;

import java.util.ArrayList;
import java.util.HashMap;

public class maximumLengthOfUnsortedArray {
	public class Solution {
		public ArrayList<Integer> subUnsort(ArrayList<Integer> arr) {
			ArrayList<Integer> list = new ArrayList<>();
			// Find the element which is greater than its next
			int n = arr.size(), s = 0;
			for (int i = 0; i < n - 1; i++) {
				if (arr.get(i) > arr.get(i + 1)) {
					s = i;
					break;
				}
			}
			// Find the element whose prev is greater than it
			int e = 0;
			for (int i = n - 1; i > 0; i--) {
				if (arr.get(i) < arr.get(i - 1)) {
					e = i;
					break;
				}
			}
			int max = arr.get(s);
			int min = arr.get(s);
			// Find the max and min in the unsorted array
			for (int i = s; i <= e; i++) {
				max = Math.max(max, arr.get(i));
				min = Math.min(min, arr.get(i));
			}
			// Now check if this unsorted array can be expanded or not

			// Find the first larger element in the left part
			for (int i = 0; i < s; i++) {
				if (arr.get(i) > min) {
					s = i;
					break;
				}
			}
			// Find the first smaller element in right part
			for (int i = e + 1; i < n - 1; i++) {
				if (arr.get(i) < max) {
					e = i;
					break;
				}
				ArrayList<Integer> li = new ArrayList<>();
				HashMap<Integer,Integer> map=new HashMap<>();
				
			}
			for (int i = s; i <= e; i++) {
				list.add(arr.get(i));
			}
			return list;
		}
	}

}

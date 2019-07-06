package Heap;

import java.util.List;
import java.util.PriorityQueue;

public class smallestRangeInKLists {
	class Solution {

		class tuple implements Comparable<tuple> {
			int x;
			int y;
			int val;

			tuple(int x, int y, int val) {
				this.x = x;
				this.y = y;
				this.val = val;
			}

			public int compareTo(tuple other) {
				if (this.val < other.val) {
					return -1;
				} else if (this.val > other.val) {
					return 1;
				} else {
					return 0;
				}
			}
		}

		public int[] smallestRange(List<List<Integer>> nums) {
			PriorityQueue<tuple> pq = new PriorityQueue<>();
			int n = nums.size();
			int[] range = new int[2];
			int minrange = Integer.MAX_VALUE;
			int currmax = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				currmax = Math.max(currmax, nums.get(i).get(0));
				pq.add(new tuple(i, 0, nums.get(i).get(0)));
			}

			while (true) {
				tuple top = pq.peek();
				pq.remove();
				// Update the minimum range
				int currmin = nums.get(top.x).get(top.y);
				System.out.println(currmin + " " + currmax);
				if ((currmax - currmin) < minrange) {
					range[0] = currmin;
					range[1] = currmax;
					minrange = currmax - currmin;
				}
				// Break if new entry cannot be added
				if (top.y == nums.get(top.x).size() - 1) {
					break;
				}

				// Add new entry
				pq.add(new tuple(top.x, top.y + 1, nums.get(top.x).get(top.y + 1)));
				// Update the maximum entry
				currmax = Math.max(currmax, nums.get(top.x).get(top.y + 1));

			}
			return range;
		}
	}
}
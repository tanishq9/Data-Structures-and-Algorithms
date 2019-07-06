package Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskScheduler {
	class Solution {

		public int leastInterval(char[] tasks, int n) {
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < tasks.length; i++) {
				map.put(tasks[i] + "", map.getOrDefault(tasks[i] + "", 0) + 1);
			}
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for (String key : map.keySet()) {
				pq.add(map.get(key));
			}
			int interval = 0;
			while (pq.size() > 0) {
				int iter = 0;
				ArrayList<Integer> list = new ArrayList<>();
				while (iter <= n) {
					if (pq.size() != 0) {
						int top = pq.remove();
						if (top > 1) {
							list.add(top - 1);
						}
					}
					interval++;
					if (list.size() == 0 && pq.size() == 0) {
						break;
					}
					iter++;
				}
				for (int l : list) {
					pq.add(l);
				}
			}
			return interval;
		}
	}
}
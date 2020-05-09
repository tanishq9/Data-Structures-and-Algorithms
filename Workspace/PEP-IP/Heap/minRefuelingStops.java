package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class minRefuelingStops {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int totalFuel = startFuel;
		int stops = 0;
		int n = stations.length, i = 0;
		// Build a max heap of petrol and check how many times we will have to stop to
		// refuel
		while (totalFuel < target) {
			// jaha jaha ja sakte ho uska fuel daaldo pq mei
			while (i < n && stations[i][0] <= totalFuel) {
				pq.add(stations[i++][1]);
			}
			if (pq.size() == 0) {
				return -1;
			}
			totalFuel += pq.remove();
			stops++;
		}
		return stops;
	}
}

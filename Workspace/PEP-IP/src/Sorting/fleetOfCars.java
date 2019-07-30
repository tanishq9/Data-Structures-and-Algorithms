package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class fleetOfCars {
	class Tuple implements Comparable<Tuple> {
		int speed;
		int distance;
		double time;

		Tuple(int distance, int speed, double time) {
			this.speed = speed;
			this.distance = distance;
			this.time = time;
		}

		public int compareTo(Tuple o) {
			return o.distance - this.distance;
		}
	}

	public int carFleet(int target, int[] position, int[] speed) {
		if (position.length == 0) {
			return 0;
		}
		ArrayList<Tuple> list = new ArrayList<>();
		for (int i = 0; i < position.length; i++) {
			int targetDistance = target - position[i];
			list.add(new Tuple(targetDistance, speed[i], (targetDistance * 1.0) / speed[i]));
		}
		Collections.sort(list);
		int fleets = 1;
		for (int i = list.size() - 1; i >= 1; i--) {
			if (list.get(i).time < list.get(i - 1).time) {
				System.out.println(list.get(i).time + " " + list.get(i - 1).time);
				fleets++;
			} else {
				list.get(i - 1).time = list.get(i).time;
			}
		}
		return fleets;
	}
}

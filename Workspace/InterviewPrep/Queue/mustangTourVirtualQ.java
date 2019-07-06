package Queue;

public class mustangTourVirtualQ {
	public static int mustangTour(int[] petrol, int[] dist) {
		for (int i = 0; i < petrol.length; i++) {
			if (isCircularTourPossible(i, petrol, dist)) {
				return i;
			}
		}
		return -1;
	}

	public static boolean isCircularTourPossible(int i, int[] petrol, int[] dist) {
		int start = i;
		int petrolrem = 0;
		do {
			petrolrem += petrol[i] - dist[i];
			if (petrolrem < 0) {
				return false;
			}
			if (petrolrem >= 0) {
				i++;
			}
			if (i == petrol.length) {
				i = 0;
			}
		} while (start != i);

		return true;
	}

}

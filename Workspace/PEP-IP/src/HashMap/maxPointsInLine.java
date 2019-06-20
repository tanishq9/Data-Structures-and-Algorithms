package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class maxPointsInLine {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 1 2 1 1 2 2
		while (T > 0) {
			int N = sc.nextInt();

			int x[] = new int[N];
			int y[] = new int[N];
			for (int i = 0; i < N; i++)
				x[i] = sc.nextInt();
			for (int i = 0; i < N; i++)
				y[i] = sc.nextInt();
			System.out.println(new GfG().noOfPoints(x, y, N));
			T--;
		}
	}
}

class GfG {
	class Pair {
		int dx;
		int dy;

		Pair(int idx, int idy) {
			this.dx = idx;
			this.dy = idy;
		}

		public int hashCode() {
			return dx + dy;
		}

		public boolean equals(Object o) {
			Pair other = (Pair) o;
			if (this.dx == other.dx && this.dy == other.dy) {
				return true;
			} else {
				return false;
			}
		}

	}

	int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	int noOfPoints(int x[], int y[], int n) {

		HashMap<Pair, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int dx = x[i] - x[j];
				int dy = y[i] - y[j];
				if (dx == 0 && dy == 0) {
					continue;
				}
				int r = gcd(dx, dy);
				dx = dx / r;
				dy = dy / r;
				Pair curr = new Pair(dx, dy);
				if (map.containsKey(curr)) {
					map.put(curr, map.get(curr) + 1);
				} else {
					map.put(curr, 2);
				}
				max = Math.max(max, map.get(curr));
			}
			map.clear();
		}
		return max;
	}
}

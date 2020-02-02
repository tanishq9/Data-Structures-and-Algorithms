package Graph;

public class floydWarshall {

	public static void main(String[] args) {
		int[][] wts = { { Integer.MAX_VALUE, 2, 8, 10 }, { Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 7 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE } };
		for (int i = 0; i < wts.length; i++) {
			for (int j = 0; j < wts[0].length; j++) {
				if (wts[i][j] == Integer.MAX_VALUE) {
					System.out.print("NO\t");
				} else {
					System.out.print(wts[i][j] + "\t");
				}
			}
			System.out.println();
		}
		floyd(wts);
		System.out.println();
		// Display again
		for (int i = 0; i < wts.length; i++) {
			for (int j = 0; j < wts[0].length; j++) {
				if (wts[i][j] == Integer.MAX_VALUE) {
					System.out.print("NO\t");
				} else {
					System.out.print(wts[i][j] + "\t");
				}
			}
			System.out.println();
		}
	}

	public static void floyd(int[][] wts) {
		for (int in = 0; in < wts.length; in++) {
			for (int src = 0; src < wts.length; src++) {
				for (int dest = 0; dest < wts.length; dest++) {
					if (in != src && in != dest && src != dest && wts[in][dest] != Integer.MAX_VALUE
							&& wts[src][in] != Integer.MAX_VALUE) {
						if (wts[src][in] + wts[in][dest] < wts[src][dest]) {
							wts[src][dest] = wts[src][in] + wts[in][dest];
						}
					}
				}
			}
		}
	}

}

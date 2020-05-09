package Array;

public class rangeAddition2 {
	public int maxCount(int m, int n, int[][] ops) {
		if (ops == null || ops.length == 0) {
			return m * n;
		}
		// visualize the matrix after all operations to get the trick

		int tl = Integer.MAX_VALUE; // top left
		int br = Integer.MAX_VALUE; // bottom right
		for (int[] op : ops) {
			tl = Math.min(tl, op[0]);
			br = Math.min(br, op[1]);
		}
		return tl * br;
	}
}

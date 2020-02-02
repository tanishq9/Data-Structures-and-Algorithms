package RQ;

public class sparse {

	static int[][] sparse = null;

	private static void preprocess(int[] arr) {
		int log = getFloor(arr.length);
		sparse = new int[arr.length][log + 1];
		for (int i = 0; i < arr.length; i++) {
			sparse[i][0] = arr[i];
		}
		for (int j = 1; j < sparse[0].length; j++) {
			for (int i = 0; i <= (sparse.length - (1 << j)); i++) {
				int f1 = sparse[i][j - 1];
				int f2 = sparse[i + (1 << j - 1)][j - 1];
				sparse[i][j] = Math.min(f1, f2);
			}
		}
	}

	private static int query(int l, int r) {
		int c = r - l + 1;
		int f1 = sparse[l][getFloor(c)];
		int f2 = sparse[r - (1 << getFloor(c)) + 1][getFloor(c)];
		return Math.min(f1, f2);
	}

	private static int getFloor(int n) {
		int log = 0;
		while ((1 << log) <= n) {
			log++;
		}
		return log - 1;
	}

	public static void main(String[] args) {
		int[] arr = new int[15];
		arr[0] = -5;
		arr[1] = 5;
		arr[2] = 4;
		arr[3] = 1;
		arr[4] = 7;
		arr[5] = 11;
		arr[6] = 12;
		arr[7] = 14;
		arr[8] = 6;
		arr[9] = 9;
		arr[10] = 10;
		arr[11] = 1;
		arr[12] = 7;
		arr[13] = 9;
		arr[14] = 2;
		preprocess(arr);
		System.out.println(query(10, 12));
	}

}

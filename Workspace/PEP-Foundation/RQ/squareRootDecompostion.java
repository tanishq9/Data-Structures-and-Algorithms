package RQ;

public class squareRootDecompostion {

	static int[] oa;
	static int[] sqrt;
	static int bs;
	static int bn;

	private static void preprocess(int[] arr) {
		bs = (int) Math.sqrt(arr.length);
		bn = oa.length / bs;
		// Alternatively , we can take ceil , else use if check to check
		// if index is not going out of bounds
		bn = (int) Math.ceil(oa.length * 1.0 / bs);
		sqrt = new int[bn];
		for (int i = 0; i < oa.length; i++) {
			int b = i / bs;
			// dont use if check if using ceil
			if (b < sqrt.length) {
				sqrt[b] += oa[i];
			}
		}
	}

	private static int query(int l, int r) {
		int lb = l / bs;
		int rb = r / bs;
		if (lb == rb) {
			int sum = 0;
			for (int i = l; i <= r; i++) {
				sum += oa[i];
			}
			return sum;
		}
		int sum = 0;
		// Left part
		for (int i = l; i / bs == lb; i++) {
			sum += oa[i];
		}

		// Inside part
		for (int i = lb + 1; i <= rb - 1; i++) {
			sum += sqrt[i];
		}

		// Right part
		for (int i = r; i / bs == rb; i--) {
			sum += oa[i];
		}
		return sum;
	}

	private static void update(int idx, int val) {
		int bi = idx / bn;
		if (bi < sqrt.length) {
			sqrt[bi] -= oa[idx];
			sqrt[bi] += val;
		}
		oa[idx] = val;
	}

	private static int queryTest(int l, int r) {
		int sum = 0;
		for (int i = l; i <= r; i++) {
			sum += oa[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int n = 49;
		oa = new int[n];
		for (int i = 0; i < n; i++) {
			oa[i] = (int) (Math.random() * 10);
		}
		preprocess(oa);
		System.out.println(query(15, 27) + " " + queryTest(15, 27));
	}

}

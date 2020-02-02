package DP_Pep;

public class squareRootDecomposition {

	private static int queryTest(int[] arr, int l, int r) {
		int sum = 0;
		for (int i = l; i <= r; i++) {
			sum += arr[i];
		}
		return sum;
	}

	private static int query(int[] arr, int[] sqrt, int bs, int l, int r) {
		int lb = l / bs; // getting the left block
		int rb = r / bs; // getting the right block
		if (lb == rb) {
			int sum = 0;
			for (int i = l; i <= r; i++) {
				sum += arr[i];
			}
			return sum;
		}
		int sum = 0;
		// left part
		for (int i = l; i / bs == lb; i++) {
			sum += arr[i];
		}
		// lb-1 to rb+1
		for (int i = lb + 1; i <= rb - 1; i++) {
			sum += sqrt[i];
		}
		// right part
		for (int i = r; i / bs == rb; i--) {
			sum += arr[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] arr = new int[39];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10);
		}
		int bs = (int) Math.sqrt(arr.length) + 1; // Size of each block
		int bn = arr.length / bs; // Number of blocks
		// Preprocessing
		int[] sqrt = new int[bn + 1];
		for (int i = 0; i < arr.length; i++) {
			int block_idx = i / bs;
			sqrt[block_idx] += arr[i];
		}
		System.out.println(query(arr, sqrt, bs, 13, 33) + "  " + queryTest(arr, 13, 33));
	}

}

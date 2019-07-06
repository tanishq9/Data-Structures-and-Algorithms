package Array;

public class rangeAddition1_Array {
	public static int[] getModifiedArray(int length, int[][] updates) {
		// write your code here.
		int[] arr = new int[length];
		for (int[] op : updates) {
			arr[op[0]] += op[2];
			if ((op[1] + 1) < length) {
				arr[op[1] + 1] += -op[2];
			}
		}
		for (int i = 1; i < length; i++) {
			arr[i] += arr[i - 1];
		}

		return arr;
	}
}

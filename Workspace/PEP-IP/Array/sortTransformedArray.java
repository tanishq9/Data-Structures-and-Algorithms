package Array;

public class sortTransformedArray {
	public static int[] sortTransformedArrayLeet(int[] arr, int a, int b, int c) {
		// Write your code here
		int i = 0;
		int j = arr.length - 1;
		int[] output = new int[arr.length];
		int index = arr.length - 1;
		while (i <= j) {
			int ic = a * arr[i] * arr[i] + b * arr[i] + c;
			int jc = a * arr[j] * arr[j] + b * arr[j] + c;
			if (ic > jc) {
				output[index--] = ic;
				i++;
			} else {
				output[index--] = jc;
				j--;
			}
		}
		return output;
	}
}

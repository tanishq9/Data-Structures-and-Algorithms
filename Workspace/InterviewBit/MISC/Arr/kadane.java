package Arr;

public class kadane {

	public static int kadane(int[] arr) {
		int cs = 0, ms = 0;
		for (int i = 0; i < arr.length; i++) {
			cs += arr[i];
			if (cs < 0) {
				cs = 0;
			}
			ms = Math.max(ms, cs);
		}
		return ms;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 6, -1, 4, 5, -7 };
		System.out.println(kadane(arr));
	}

}

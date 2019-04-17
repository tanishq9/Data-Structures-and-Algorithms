package DynamicProgramming;

public class longestBitonicSubsequene {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 9, 7, 6, 3, 1 };
		int[] lis = new int[arr.length];
		int[] lds = new int[arr.length];
		// Every single element is an increasing subsequence of length 1
		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}
		// Every single element is a decreasing subsequence of length 1
		for (int i = lds.length - 1; i >= 0; i--) {
			lds[i] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					int curr_len = lis[j] + 1;
					lis[i] = Math.max(lis[i], curr_len);
				}
			}
		}

		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[i] > arr[j]) {
					int curr_len = lds[j] + 1;
					lds[i] = Math.max(lds[i], curr_len);
				}
			}
		}

		int max = -1;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(lis[i] + lds[i] - 1, max);
		}
		System.out.println(max);
	}
}

package DynamicProgramming;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 19, 2, 3, 1, 4, 8, 10 };
		int[] lis = new int[arr.length];
		// Every element is an increasing subsequence of length 1
		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
		}
		int max_len = lis[0];
		lis[0] = 1;
		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
			for (int j = 1; j < arr.length; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
			max_len = Math.max(max_len, lis[i]);
		}

		int max = -1, max_index = -1;
		for (int i = 0; i < lis.length; i++) {
			if (max < lis[i]) {
				max = lis[i];
				max_index = i;
			}
		}
		for (int i = max_index; i >= 0; i--) {
			if (lis[i] == max) {
				System.out.print(arr[i] + " ");
				max--;
			}
		}

	}

}

package Arr;

public class stockSellOnce {

	public int maximizeProfit(int[] arr) {
		int min_element = arr[0];
		int max_diff_so_far = arr[1] - arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - min_element < max_diff_so_far) {
				max_diff_so_far = arr[i] - min_element;
			}
			if (min_element < arr[i]) {
				min_element = arr[i];
			}
		}
		return max_diff_so_far;
	}

	
	
	public static void main(String[] args) {

	}

}

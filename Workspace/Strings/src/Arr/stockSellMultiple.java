package Arr;

public class stockSellMultiple {

	public static int stockMultiple(int[] arr) {
		int profit = 0;
		int buyIndex = 0, sellIndex = 0, i = 0;
		while (i < arr.length) {
			// buy condition
			while (i < (arr.length - 1) && arr[i] >= arr[i + 1]) {
				i++;
			}
			if (i == arr.length - 1) {
				break;
			}
			buyIndex = i++;
			// Sell condition
			while (i < arr.length && arr[i - 1] >= arr[i]) {
				i++;
			}
			sellIndex = i;
			profit += arr[sellIndex] - arr[buyIndex];
		}
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 100, 180, 260, 310, 40, 740, 695 };
		System.out.println(stockMultiple(arr));
	}
}

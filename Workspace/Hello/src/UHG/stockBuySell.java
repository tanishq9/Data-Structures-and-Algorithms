package UHG;

public class stockBuySell {

	public static void main(String[] args) {
		int arr[] = { 100, 180, 260, 310, 40, 535 };
		int n = arr.length, i = 0;
		while (i < arr.length) {
			while (i < (n - 1) && arr[i] >= arr[i + 1]) {
				i++;
			}
			if (i == n - 1) {
				break;
			}
			System.out.print("BUY :" + i + " ");
			i++;
			while (i < n && arr[i - 1] <= arr[i]) {
				i++;
			}
			i--;
			System.out.println("SELL :" + i);
		}
	}
}

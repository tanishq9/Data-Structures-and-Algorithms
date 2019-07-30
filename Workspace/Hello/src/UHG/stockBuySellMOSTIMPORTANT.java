package UHG;

public class stockBuySellMOSTIMPORTANT {

	public static void main(String[] args) {
		int[] arr = { 10, 18, 26, 31, 4, 55 };
		int n = arr.length, i = 0;
		while (i < n) {
			while (i < (n - 1) && arr[i] >= arr[i + 1]) {
				i++;
			}
			if (i == n - 1) {
				break;
			}
			System.out.print("Buy at : " + arr[i] + ",");
			i++;
			while (i < n && arr[i] >= arr[i - 1]) {
				i++;
			}
			i--;
			System.out.println("Sell at : " + arr[i]);
		}
	}

}

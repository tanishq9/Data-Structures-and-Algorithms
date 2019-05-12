package SlidingWindow;

public class sumLessThanK {

	public static void main(String[] args) {
		String str = "1234";
		int[] arr = new int[str.length()];
		for (int i = 0; i < arr.length; i++) {
			int num = str.charAt(i) - '0';
			arr[i] = num;
		}
		int start = 0, end = 0, count = 0, sum = arr[0];
		int k = 4;
		while (start < arr.length && end < arr.length) {
			System.out.println(start + " " + end);
			if (sum <= k) {
				end++;
				if (end >= start) {
					System.out.println(end - start);
					count += end - start;
				}
				if (end < arr.length) {
					sum += arr[end];
				}
			} else {
				sum -= arr[start];
				start++;
			}
			System.out.println();
		}
		System.out.println(count);
	}
}

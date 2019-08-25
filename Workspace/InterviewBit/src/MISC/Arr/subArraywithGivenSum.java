package Arr;

public class subArraywithGivenSum {

	public static void main(String[] args) {
		int[] arr = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int curr = arr[0], start = 0, sum = 21;
		Boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			while (curr > sum && start <= i) { // start < i-1
				curr -= arr[start];
				start++;
			}
			if (curr == sum) {
				flag = true;
				break;
			}
			curr += arr[i];
		}
		System.out.println(flag);
	}
}

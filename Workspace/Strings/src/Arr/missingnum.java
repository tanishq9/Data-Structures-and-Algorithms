package Arr;

public class missingnum {

	static int isMissing(int[] arr, int num) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		int expectedSum = ((num) * (num + 1)) / 2;
		return expectedSum - sum;
	}

	static int XORapproach(int[] arr, int num) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum ^= arr[i];
		}
		int expectedSum = 0;
		for (int i = 1; i <= num; i++) {
			expectedSum ^= i;
		}
		return expectedSum ^ sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 5, 4, 1 };
		System.out.println(isMissing(arr, 5));
		System.out.println(XORapproach(arr, 5));
	}

}

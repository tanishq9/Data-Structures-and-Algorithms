package IBit;

public class maximumSumPath {

	public static void main(String[] args) {
		int arr1[] = { 2, 3, 7, 10, 12, 15, 30, 34 };
		int arr2[] = { 1, 5, 7, 8, 10, 15, 16, 19 };
		int i = 0, j = 0, arr1Sum = 0, arr2Sum = 0, totalSum = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] > arr2[j]) {
				arr2Sum += arr2[j++];
			} else if (arr1[i] < arr2[j]) {
				arr1Sum += arr1[i++];
			} else {
				totalSum += (Math.max(arr1Sum + arr1[i], arr2Sum + arr1[i]));
				i++;
				j++;
				arr1Sum = 0;
				arr2Sum = 0;
			}
		}
		while (i < arr1.length) {
			arr1Sum += arr1[i++];
		}
		while (j < arr2.length) {
			arr2Sum += arr2[j++];
		}
		totalSum += Math.max(arr1Sum, arr2Sum);
		System.out.println(totalSum);
	}

}

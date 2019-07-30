package IBIT;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		int[] arr = { 1967513926, 1540383426, -1303455736, -521595368 };
		int si = 0, ei = 0, finalSi = 0, finalEi = 0, maxCount = 0, maxSum = 0;
		int currCount = 0, currSum = 0;
		for (int i = 0; i < arr.length; i++) {
			currCount = 0;
			currSum = 0;
			si = i;
			while (i < arr.length && arr[i] >= 0) {
				currCount += 1;
				System.out.println(currSum);
				currSum += arr[i];
				System.out.println(currSum);
				i++;
			}
			ei = i - 1;
			if (currSum > maxSum) {
				finalEi = ei;
				finalSi = si;
				maxSum = currSum;
				maxCount = currCount;
			} else if (currSum == maxSum) {
				if (currCount > maxCount) {
					finalEi = ei;
					finalSi = si;
					maxCount = currCount;
				}
			}
		}
		if (currSum > maxSum) {
			finalEi = ei;
			finalSi = si;
			maxSum = currSum;
			maxCount = currCount;
		} else if (currSum == maxSum) {
			if (currCount > maxCount) {
				finalEi = ei;
				finalSi = si;
				maxCount = currCount;
			}
		}

		for (int i = finalSi; i <= finalEi; i++) {
			if (arr[i] >= 0) {
				System.out.print(arr[i] + " ");
			}
		}
	}

}

package Array;

public class arrayRotationMaxSum {
	public int maxRotateFunction(int[] A) {
		int allSum = 0;
		int f = 0;
		int n = A.length;
		for (int i = 0; i < n; i++) {
			allSum += A[i];
			f += A[i] * i;
		}
		int max = f;
		for (int i = 0; i < n - 1; i++) {
			f = f - allSum + A[i] * n;
			max = Math.max(max, f);
		}
		return max;
	}
}

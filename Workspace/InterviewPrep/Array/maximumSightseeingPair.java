package Array;

public class maximumSightseeingPair {
	public int maxScoreSightseeingPair(int[] A) {
		int distance = A[0];
		int max = Integer.MIN_VALUE;
		// maximize (a[i]+j-i)+a[j]
		for (int i = 1; i < A.length; i++) {
			distance--;
			max = Math.max(max, distance + A[i]);
			if (distance < A[i]) {
				distance = A[i];
			}
		}
		return max;
	}
}

package Array;

public class findPoisonedDuration {
	public static int findPoisoned_Duration(int[] timeSeries, int duration) {
		// Write your code here
		int start = timeSeries[0];
		int end = start + duration;
		int result = 0;
		for (int i = 1; i < timeSeries.length; i++) {
			// No overlap
			if (timeSeries[i] > end) {
				result += (end - start);
				start = timeSeries[i];
			}
			// Merge : Don't change the start
			end = timeSeries[i] + duration;
		}

		result += end - start;
		return result;
	}
}

package Array;

public class localAndGlobalInversion {
	public static boolean isIdealPermutation(int[] A) {
		// write your code here.
		int max = 0;
		int n = A.length;
		for (int i = 0; i < n - 2; i++) {
			max = Math.max(max, A[i]);
			// abhi tak ke maximum ko i+2 ke saath compare karde
			// to get first potential global that is not local
			if (max > A[i + 2]) {
				return false;
			}
		}
		return true;
	}
}

package Array;

public class sortArrayByParity {
	public int[] sortArrayByParity(int[] A) {
		int i = 0; // i ke pehle saare odd hai ; this is the use of this pointer
		int j = 0; // for check and swap even with odd which increases i
		while (j < A.length) {
			// even
			if (A[j] % 2 == 0) {
				// swap i and j
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				// Increase i as we have ACQUIRED an even element
				i++;
				j++;
			} else {
				j++;
			}
		}
		int[] out = new int[A.length];
		for (int k = 0; k < A.length; k++) {
			out[k] = A[k];
		}
		return out;
	}
}

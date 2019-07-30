package BitMasking;

public class isPowerOf2 {
	public boolean isPowerOfTwo(int n) {
		int csb = 0;
		while (n > 0) {
			if ((n & 1) == 1) {
				csb++;
			}
			n = n >> 1;
		}
		return csb == 1;
	}
}

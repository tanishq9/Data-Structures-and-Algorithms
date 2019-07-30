package Adobe;

public class reverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 13;
		int rev = 0;
		while (n > 0) {
			rev = rev << 1;
			if ((n & 1) == 1) {
				rev = rev ^ 1;
			}
			n = n >> 1;
		}
		System.out.println(rev);
	}
}

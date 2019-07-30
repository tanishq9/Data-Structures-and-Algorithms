package UHG;

public class reverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 13;
		int rev = 0;
		while (a > 0) {
			rev = rev << 1;
			if ((a & 1) == 1) {
				rev = rev | 1;
			}
			a = a >> 1;
		}
		System.out.println(rev);
	}

}

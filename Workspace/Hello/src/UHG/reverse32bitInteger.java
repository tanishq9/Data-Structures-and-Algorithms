package UHG;

public class reverse32bitInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long i = 31, a = 13, x = 0;
		while (i != 0) {
			x = x | ((a & 1) << i); // matlab jo bit aayegi usse left shift kardo
			a = a >> 1;
			i--;
		}
		System.out.println(x);
	}

}

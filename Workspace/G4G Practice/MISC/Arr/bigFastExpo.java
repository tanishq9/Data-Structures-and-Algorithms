package Arr;

public class bigFastExpo {
	// Maximum number of digits in
	// output
	static final int MAX = 100000;

	// This function multiplies x
	// with the number represented by res[].
	// res_size is size of res[] or
	// number of digits in the number
	// represented by res[]. This function
	// uses simple school mathematics
	// for multiplication.
	// This function may value of res_size
	// and returns the new value of res_size
	static int multiply(int x, int res[], int res_size) {

		// Initialize carry
		int carry = 0;

		// One by one multiply n with
		// individual digits of res[]
		for (int i = 0; i < res_size; i++) {
			int prod = res[i] * x + carry;

			// Store last digit of
			// 'prod' in res[]
			res[i] = prod % 10;

			// Put rest in carry
			carry = prod / 10;
		}

		// Put carry in res and
		// increase result size
		while (carry > 0) {
			res[res_size] = carry % 10;
			carry = carry / 10;
			res_size++;
		}
		return res_size;
	}

	// This function finds
	// power of a number x
	static void power(int x, int n) {
		int res[] = new int[MAX];
		int res_size = 0;
		int temp = x;

		// Initialize result
		while (temp != 0) {
			res[res_size++] = temp % 10;
			temp = temp / 10;
		}

		// Multiply x n times
		// (x^n = x*x*x....n times)
		for (int i = 2; i <= n; i++)
			res_size = multiply(x, res, res_size);

		System.out.print(x + "^" + n + " = ");
		for (int i = res_size - 1; i >= 0; i--)
			System.out.print(res[i]);
	}

	// Driver code
	public static void main(String[] args) {
		int exponent = 100;
		int base = 2;
		power(base, exponent);
	}

}

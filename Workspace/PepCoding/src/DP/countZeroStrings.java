package DP;

public class countZeroStrings {

	public static void main(String[] args) {
		int n = 9;
		int cz = 1;
		int co = 1;

		for (int i = 2; i <= n; i++) {
			int nco = cz + co; // new string ending with 1
			int ncz = co; // new string ending with 0
			co = nco;
			cz = ncz;
		}
		System.out.println(co + cz);
	}

}

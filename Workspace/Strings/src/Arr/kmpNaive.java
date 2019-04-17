package Arr;

public class kmpNaive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "123456";
		String tbemtch = "123";

		Boolean flag = false;
		int j = 0, k = 0;
		for (int i = 0; i < s.length() - tbemtch.length() + 1; i++) {
			for (j = i, k = 0; j < s.length() && k < tbemtch.length();) {
				if (s.charAt(j) == tbemtch.charAt(k)) {
					k++;
					j++;
				} else {
					break;
				}
			}
			if (j == (tbemtch.length() - 1)) {
				flag = true;
			}
		}
		if (flag == true) {
			System.out.println("Matched");
		} else {
			System.out.println("Not Matched");
		}
	}
}

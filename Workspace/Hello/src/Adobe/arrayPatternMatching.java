package Adobe;

public class arrayPatternMatching {

	public static void main(String[] args) {
		int[] a = { 2, 12, 14, 5, 6, 1 };
		int[] p = { 12, 14, 5 };
		Boolean found = false;
		for (int i = 0; i <= (a.length - p.length); i++) {
			int count = 0;
			for (int j = 0; j < p.length; j++) {
				if (a[i + j] == p[j]) {
					count++;
				}
			}
			if (count == p.length) {
				found = true;
				break;
			}
		}
		System.out.println(found);
	}

}

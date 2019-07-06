package HashMap;

import java.util.HashSet;

public class uniqueRowsInMatrix {
	public static void printMat(int a[][], int r, int c) {
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < r; i++) {
			String str = "";
			for (int j = 0; j < c; j++) {
				str += (a[i][j] + " ");
			}
			if (!set.contains(str)) {
				System.out.print(str + "$");
				set.add(str);
			}
		}
	}
}

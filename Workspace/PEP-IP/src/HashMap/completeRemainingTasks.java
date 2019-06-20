package HashMap;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class completeRemainingTasks {
	public static void completeTask(int n, int m, int[] compl) {
		HashSet<Integer> done = new HashSet<>();
		for (int t : compl) {
			done.add(t);
		}
		Set<Integer> tanya = new TreeSet<>();
		Set<Integer> manya = new TreeSet<>();
		boolean flag = true;
		for (int i = 1; i <= n; i++) {
			if (done.contains(i)) {
				continue;
			}
			if (flag == true) {
				tanya.add(i);
			} else {
				manya.add(i);
			}
			flag = !flag;
		}
		for (int t : tanya) {
			System.out.print(t + " ");
		}
		System.out.println();
		for (int t : manya) {
			System.out.print(t + " ");
		}
	}
}

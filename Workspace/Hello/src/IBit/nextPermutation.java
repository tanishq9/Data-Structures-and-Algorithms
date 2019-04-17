package IBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class nextPermutation {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(3);
		list.add(4);
		list.add(9);
		list.add(7);
		list.add(6);
		nextPermutation(list);
	}

	public static void nextPermutation(ArrayList<Integer> a) {
		if (a.size() == 1) {
			return;
		}
		if (a.size() == 2) {
			int temp = a.get(0);
			a.set(0, a.get(1));
			a.set(1, temp);
			return;
		}
		int justSmaller = 0;
		for (int i = a.size() - 1; i >= 0; i--) {
			if (a.get(i) > a.get(i - 1)) {
				justSmaller = i - 1;
				break;
			}
		}
		int temp = a.get(justSmaller);
		a.set(justSmaller, a.get(a.size() - 1));
		a.set(a.size() - 1, temp);
		Collections.sort(a.subList(justSmaller + 1, a.size()));
		System.out.println(a);
	}
}

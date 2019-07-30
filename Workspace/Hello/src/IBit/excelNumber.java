package IBit;

import java.util.ArrayList;
import java.util.HashMap;

public class excelNumber {

	public static void main(String[] args) {
		int A = 25;
		StringBuilder sb = new StringBuilder();
		while (A > 0) {
			int rem = A % 26;
			if (rem != 0) {
				sb.append(String.valueOf((char) (64 + rem)));
				A = A / 26;
			} else {
				sb.append("Z");
				A = A / 26 - 1;
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		// list.addAll(list2);
		list.add(1);
		list.add(2);
		list.clear();
		list2.add(2);
		list2.add(1);
		HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
		map.put(list, 1);
		map.put(list2, 1);
		System.out.println(map.size());
		System.out.println(sb.reverse().toString());
	}
}

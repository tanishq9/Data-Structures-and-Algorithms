package IBit;

import java.util.ArrayList;
import java.util.TreeMap;

public class HashMapVSTreeMap {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-2);
		list.add(-1);
		list.add(0);
		list.add(1);
		list.add(2);
		System.out.println(list);
		/*
		 * for (int i = 0; i < list.size(); i++) { System.out.print(list.get(i) + " ");
		 * if (i % 2 == 0) { list.remove(list.get(i)); } }
		 */ System.out.println();
		ArrayList<Integer> indicestoberemoved = new ArrayList<>();
		indicestoberemoved.add(0);
		indicestoberemoved.add(1);
		list.removeAll(indicestoberemoved);
		list.add(2, 2);
		// list.add(index, element);
		System.out.println(list);
		// System.out.println(removeDuplicates(list));
	}

	public static int removeDuplicates(ArrayList<Integer> a) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < a.size(); i++) {
			map.put(a.get(i), 1);
		}
		a.clear();
		for (int i : map.keySet()) {
			System.out.print(i + " ");
			a.add(i);
		}
		System.out.println();
		return map.size();
	}
}

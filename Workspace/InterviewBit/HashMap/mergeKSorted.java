package HashMap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeKSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();
		// List 1
		list1.add(2);
		list1.add(5);
		list1.add(11);
		list1.add(12);
		// List 2
		list2.add(3);
		list2.add(4);
		list2.add(7);
		// List 3
		list3.add(1);
		list3.add(6);
		list3.add(8);
		list3.add(10);
		// Add all to list
		list.add(list1);
		list.add(list2);
		list.add(list3);
		// Merge K sorted
		ArrayList<Integer> result = mergeKSorted(list, list.size());
		System.out.println(result);
	}

	static class Kheap implements Comparable<Kheap> {
		int data;
		int dataindex;
		int listindex;

		Kheap(int id, int idi, int ili) {
			this.data = id;
			this.dataindex = idi;
			this.listindex = ili;
		}

		// Minimum Heap on basis of value of data item
		@Override
		public int compareTo(Kheap other) {
			if (this.data < other.data) {
				return -1;
			} else if (this.data > other.data) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	private static ArrayList<Integer> mergeKSorted(ArrayList<ArrayList<Integer>> list, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		PriorityQueue<Kheap> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			Kheap ob = new Kheap(list.get(i).get(0), 0, i);
			pq.add(ob);
		}
		while (pq.size() > 0) {
			Kheap top = pq.remove();
			int li = top.listindex;
			int di = top.dataindex;
			result.add(top.data);
			// pq.remove(); // Minimum item removed
			di += 1; // Increment the data index so as to include the next element
			if (di < list.get(li).size()) {
				pq.add(new Kheap(list.get(li).get(di), di, li));
			}
		}
		return result;
	}

}

package PriorityQueue;

import java.util.PriorityQueue;

public class mergeKSortedArrays {

	public static void main(String[] args) {
		int[][] arrays = { { 2, 3, 10, 15, 20 }, { 4, 6, 8, 11 }, { 5, 7, 9 } };
		mergeKSorted(arrays);
	}

	static class Helper implements Comparable<Helper> {
		int data;
		int listNum;
		int dataNum;

		Helper(int idata, int ilistnum, int idatanum) {
			this.data = idata;
			this.listNum = ilistnum;
			this.dataNum = idatanum;
		}

		@Override
		public int compareTo(Helper other) {
			if (this.data < other.data) {
				return -1;
			} else if (this.data > other.data) {
				return 1;
			} else {
				return 0;
			}
		}

	}

	public static void mergeKSorted(int[][] data) {
		// Starting Index of each sorted array : 0 for all initially
		PriorityQueue<Helper> pq = new PriorityQueue<>();
		// Add first elements of every array : O(K)
		for (int i = 0; i < data.length; i++) {
			pq.add(new Helper(data[i][0], i, 0));
		}
		// n*log(k)
		while (!pq.isEmpty()) {
			Helper peek = pq.peek();
			System.out.print(peek.data + " ");
			pq.remove();
			peek.dataNum++;
			if (data[peek.listNum].length > peek.dataNum) {
				pq.add(new Helper(data[peek.listNum][peek.dataNum], peek.listNum, peek.dataNum));
			}
		}

	}

}

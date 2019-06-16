package SAPLabs;

import java.util.ArrayList;
import java.util.Scanner;

public class KthLargest {
	public static ArrayList<Integer> data = new ArrayList<>();

	public static void build(int[] arr) {

		for (int i : arr) {
			data.add(i);
		}

		for (int i = (data.size() / 2 - 1); i >= 0; i--) {
			downHeapify(i);
		}
	}

	public static void remove() {
		swap(0, data.size() - 1);
		data.remove(data.size() - 1);
		// Also maintain the priority property
		downHeapify(0);// kyuki yaha pe galat element hai
		// return rv;
	}

	public static int max() {
		return data.get(0);
	}

	private static void downHeapify(int pi) {
		int curr = pi;
		// System.out.println(data.get(pi));
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		if (lci < data.size() && data.get(lci) > data.get(curr)) {
			curr = lci;
		}
		if (rci < data.size() && data.get(rci) > data.get(curr)) {
			curr = rci;
		}
		if (curr != pi) {
			swap(curr, pi);
			downHeapify(curr);
		}
	}

	private static int Kth(int[] arr, int k) {
		build(arr);
		for (int i = 1; i <= k - 1; i++) {
			// System.out.print(max() + " ");
			remove();
		}
		return max();
	}

	private static void swap(int curr, int pi) {
		int temp = data.get(curr);
		data.set(curr, data.get(pi));
		data.set(pi, temp);
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 7, 1, 9, 0, 8 };
		// 8 4 3 2 7 1 9 0 8
		/*
		 * Scanner s = new Scanner(System.in); int n = s.nextInt(); for (int i = 0; i <
		 * n; i++) { data.set(i, s.nextInt()); }
		 */
		System.out.println(Kth(arr, 2));
		// System.out.println(data);
	}
}

/*
 * package SAPLabs;
 * 
 * import java.util.Scanner;
 * 
 * public class KthLargest { static int heap_size=10; public static int[] data =
 * new int[heap_size];
 * 
 * public static void build(int[] arr) {
 * 
 * for (int i : arr) { data.add(i); }
 * 
 * for (int i = data.length / 2 - 1; i >= 0; i--) { downHeapify(i); } }
 * 
 * private void upheapify(int i) { if (i == 0) { return; } int pi = (i - 1) / 2;
 * if (data[pi] < data[i]) { swap(data[i], data[pi]); upheapify(i);// this means
 * the element can still go up in the heap } }
 * 
 * public static void remove() { swap(0, data.length - 1); // int rv =
 * data.remove(data.length - 1); // Also maintain the priority property
 * downHeapify(0);// kyuki yaha pe galat element hai // return rv; }
 * 
 * public static int max() { return data[0]; }
 * 
 * private static void downHeapify(int pi) { int curr = pi; int lci = 2 * pi +
 * 1; int rci = 2 * pi + 2; if (lci < data.length && data[lci] > data[pi]) {
 * curr = lci; } if (rci < data.length && data[rci] > data[pi]) { curr = rci; }
 * if (curr != pi) { swap(curr, pi); downHeapify(curr); } }
 * 
 * private static int Kth(int[] arr, int k) { build(arr);
 * System.out.println(max()); for (int i = 1; i <= k - 1; i++) { remove();
 * System.out.print(max() + " "); } return max(); }
 * 
 * private static void swap(int curr, int pi) { int temp = data[curr];
 * data[curr] = data[pi]; data[pi] = temp; }
 * 
 * public static void main(String[] args) { // data={4,3,2,7,1,9,0,8}; // 8 4 3
 * 2 7 1 9 0 8 Scanner s = new Scanner(System.in); int n = s.nextInt(); for (int
 * i = 0; i < n; i++) { data[i] = s.nextInt(); } System.out.println(Kth(data,
 * 3)); for (int i = 0; i < n; i++) { System.out.print(data[i] + " "); } }
 * 
 * }
 */

package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KLargest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = { 3, 4, 1, 15, 20, 56, 32, 5, 39 };
		Heap heap = new Heap();
		heap.kMaxElements(arr, 3);
		Queue<Integer> queue = new PriorityQueue<>();
		// Queue<Integer> queue=new PriorityQueue<>();
		int n = scanner.nextInt();
		// Assume we have 3 arrays and all the arrays are of size 3
		int[][] karr = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				karr[i][j] = scanner.nextInt();
			}
		}
		heap.mergeKsorted(karr, 3);
	}
}

class myCmp implements Comparator<Integer> {

	@Override
	public int compare(Integer arg0, Integer arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
}

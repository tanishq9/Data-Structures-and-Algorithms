package Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class Heap {

	private ArrayList<Integer> list;

	Heap() {
		list = new ArrayList<>();
	}

	Heap(ArrayList<Integer> arr) {
		list = new ArrayList<>();

		for (int i = 0; i < arr.size(); i++) {
			list.add(arr.get(i));
		}

		for (int i = (arr.size() / 2) - 1; i >= 0; i--) {
			downheapify(i);
		}
	}

	public int peek() {
		return list.get(0);
	}

	public void add(int data) {
		list.add(data);
		upheapify(list.size() - 1);
	}

	public void remove() {
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		downheapify(0);
	}

	public int size() {
		return list.size();
	}

	private void upheapify(int ci) {
		if (ci == 0) {
			return;
		}
		int pi = (ci - 1) / 2;
		if (list.get(pi) > list.get(ci)) {
			swap(pi, ci);
			upheapify(pi);
		}
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int new_parent = pi;
		if (lci < list.size() && list.get(new_parent) > list.get(lci)) {
			new_parent = lci;
		}
		if (rci < list.size() && list.get(new_parent) > list.get(rci)) {
			new_parent = rci;
		}
		if (pi != new_parent) {
			swap(pi, new_parent);
			downheapify(new_parent);
		}
	}

	private void swap(int ci, int pi) {
		int temp = list.get(ci);
		list.set(ci, list.get(pi));
		list.set(pi, temp);
	}

	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.add(10);
		heap.add(30);
		heap.add(40);
		heap.add(5);
		heap.add(55);
		heap.add(34);
		System.out.println(heap.list);

		while (heap.size() > 0) {
			System.out.print(heap.peek() + " ");
			heap.remove();
		}

		System.out.println();

		Integer[] ar = { 10, 55, 34, 30, 40, 5 };
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(ar));
		heap = new Heap(arr);
		System.out.println(heap.list);

		while (heap.size() > 0) {
			System.out.print(heap.peek() + " ");
			heap.remove();
		}

	}

}

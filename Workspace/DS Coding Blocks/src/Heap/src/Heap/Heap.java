package Heap;

import java.util.ArrayList;

public class Heap {
	ArrayList<Integer> data = new ArrayList<>();

	Heap(int[] arrlist) {
		for (int i : arrlist) {
			this.data.add(i);
		}
		for (int i = arrlist.length / 2 - 1; i >= 0; i--) {
			this.downheapify(i);
		}
	}

	Heap() {

	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}

	public void display() {
		System.out.println(data);
	}

	public int get() {
		return this.data.get(0);
	}

	public void add(int item) {
		this.data.add(item);// by default the item is added in the end
		upheapify(this.data.size() - 1);
	}

	private void upheapify(int childIndex) {
		if (childIndex == 0) {
			return;
		}
		int parentIndex = (childIndex - 1) / 2;
		if (data.get(parentIndex) > data.get(childIndex)) {
			swap(parentIndex, childIndex);
			upheapify(parentIndex);
		}
	}

	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		this.data.set(i, jth);
		this.data.set(j, ith);
	}

	public int remove() {
		swap(0, this.data.size() - 1);
		int rv = data.remove(this.data.size() - 1);
		// Also maintain the priority property
		downheapify(0);// kyuki yaha pe galat element hai
		return rv;
	}

	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;// let say this is the minimum of the 3 values
		if (lci < this.data.size() && data.get(lci) < data.get(mini)) {
			mini = lci;
		}
		if (rci < this.data.size() && data.get(rci) < data.get(mini)) {
			mini = rci;
		}
		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}
	}

	// In heap , insert and remove take logn time , you know the reason why?
	// because at any time we are decreasing the possible outputs by half
	public void kMaxElements(int[] arr, int k) {
		int count = 0;
		Heap kSizeHeap = new Heap();
		for (int i = 0; i < arr.length; i++) {
			if (count < k) {
				kSizeHeap.add(arr[i]);
				count++;
			} else if (count == k) {// top element of heap is this.data.get(0)
				if (kSizeHeap.get() < arr[i]) {
					kSizeHeap.remove();
					kSizeHeap.add(arr[i]);
				}
			}
		}
		kSizeHeap.display();
	}

	public void mergeKsorted(int[][] karr, int k) {
		
	}
}

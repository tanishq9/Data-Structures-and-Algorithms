package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap {

	public static class HMNode {
		Integer key;
		String value;

		HMNode(Integer key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	private LinkedList<HMNode>[] buckets;
	private int size;

	HashMap() {
		initBuckets(4);
		this.size = 0;
	}

	public static void put(Integer key, String val) {

	}

	public static boolean containsKey(Integer key) {
		return true;
	}

	public static void get(Integer key) {

	}

	public static String remove(Integer key) {
		return "";
	}

	public void display() {

	}

	public static ArrayList<Integer> keyset() {
		return new ArrayList<>();
	}

	private void initBuckets(int n) {
		this.buckets = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			buckets[i] = new LinkedList<>();
		}
	}

	private int hashfunc(int key) {
		int hc = key;
		int bi = Math.abs(hc) % buckets.length;
		return bi;
	}

	private int findWithInBucket(int bi, int key) {
		for (int di = 0; di < buckets[bi].size(); di++) {
			HMNode node = buckets[bi].get(di);
			if (node.key.equals(key)) {
				return di;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

	}

}

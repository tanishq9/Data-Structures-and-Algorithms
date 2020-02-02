package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> {

	public class HMNode {
		K key;
		V value;

		HMNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			HMNode other = (HMNode) obj;
			return this.key.equals(other.key);
		}

	}

	private LinkedList<HMNode>[] buckets = null;
	public static int n;
	private int N;

	HashMap() {
		// lambda = n/N
		n = 0;
		N = 4;
		buckets = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			buckets[i] = new LinkedList<>();
		}
	}

	public boolean containsKey(K key) {
		int bi = getBucketIndex(key);
		int di = getDataIndex(bi, key);
		if (di == -1) {
			return false;
		} else {
			return true;
		}
	}

	public V get(K key) {
		int bi = getBucketIndex(key);
		int di = getDataIndex(bi, key);
		if (di == -1) {
			return null;
		} else {
			return buckets[bi].get(di).value;
		}
	}

	private int getBucketIndex(K key) {
		int bi = Math.abs(key.hashCode()) % buckets.length;
		return bi;
	}

	private int getDataIndex(int bi, K key) {
		for (int di = 0; di < buckets[bi].size(); di++) {
			HMNode node = buckets[bi].get(di);
			if (node.key.equals(key)) {
				return di;
			}
		}
		return -1;
	}

	public void put(K key, V val) {
		int bi = getBucketIndex(key);
		int di = getDataIndex(bi, key);
		// Adding key for the first time
		if (di == -1) {
			n++; // increase the size
			buckets[bi].add(new HMNode(key, val));
		}
		// Update the value corresponding to the key
		else {
			n++; // size is increased
			HMNode current = buckets[bi].get(di);
			current.value = val;
		}
		// Loading factor

		double lambda = n * 1.0 / N;
		if (lambda > 2) {
			this.rehash();
		}

	}

	private void rehash() {
		// Copy the old contents
		LinkedList<HMNode>[] old_bucket_array = this.buckets;
		buckets = new LinkedList[2 * old_bucket_array.length];
		n = 0;

		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}

		for (LinkedList<HMNode> bucket : old_bucket_array) {
			while (bucket.size() != 0) {
				HMNode node = bucket.remove();
				put(node.key, node.value);
			}
		}
	}

	public ArrayList<K> keySet() {
		ArrayList<K> keys = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < buckets[i].size(); i++) {
				HMNode node = buckets[i].get(j);
				keys.add(node.key);
			}
		}
		return keys;
	}

	// Simple Work ! -- Skip --
	public void display() {
		for (int i = 0; i < N; i++) {
			System.out.print(i + "->");
			for (int j = 0; j < buckets[i].size(); j++) {
				HMNode node = buckets[i].get(j);
				System.out.print("(" + node.key + "," + node.value + ")");
			}
			System.out.println();
		}
	}

	public V remove(K key) {
		int bi = getBucketIndex(key);
		int di = getDataIndex(bi, key);
		if (di == -1) {
			return null;
		} else {
			n--; // decrease the size
			V current = buckets[bi].get(di).value;
			buckets[bi].remove(di);
			return current;
		}
	}

	public static void main(String[] args) {
		// Loading factor is 2(lambda)
		HashMap<String, Integer> map = new HashMap<>();
		// Adding Keys
		map.put("India", 120);
		map.put("USA", 80);
		map.put("UK", 70);
		map.put("Brazil", 100);
		map.put("Germany", 75);
		map.put("France", 50);
		map.put("England", 40);
		map.put("South Africa", 60);
		map.put("Bangladesh", 30);
		map.put("Australia", 35);
		// Removing Key
		map.remove("England");
		// Updating Key
		map.put("India", 150);
		// Size of map
		System.out.println(n);
		// Display map
		map.display();
	}

}

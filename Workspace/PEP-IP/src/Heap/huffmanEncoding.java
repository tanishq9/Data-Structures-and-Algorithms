package Heap;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class huffmanEncoding {
	static class Node implements Comparable<Node> {
		String val;
		int freq;
		Node left;
		Node right;

		Node(String ival, int ifreq) {
			this.val = ival;
			this.freq = ifreq;
			this.left = null;
			this.right = null;
		}

		public int compareTo(Node other) {
			return this.freq - other.freq;
		}
	}

	private static void Huffman(String str, int[] arr) {

		HashMap<Character, Integer> encoder = new HashMap<>();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int idx = 0;
		for (char cc : str.toCharArray()) {
			encoder.put(cc, arr[idx++]);
		}
		for (char key : encoder.keySet()) {
			pq.add(new Node(key + "", encoder.get(key)));
		}
		while (pq.size() >= 2) {
			Node l1 = pq.remove();
			Node l2 = pq.remove();
			Node newNode = new Node(l1.val + l2.val + "", l1.freq + l2.freq);
			newNode.left = l1;
			newNode.right = l2;
			pq.add(newNode);
		}
		Node root = pq.remove();
		traverse(root, "");
	}

	static void traverse(Node root, String psf) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			System.out.print(psf + " ");
		}
		traverse(root.left, psf + "0");
		traverse(root.right, psf + "1");
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int[] arr = new int[str.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		Huffman(str, arr);
	}
}

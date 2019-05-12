package Huffman;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman {

	static class Node implements Comparable<Node> {
		char data;
		int freq;
		Node left;
		Node right;

		Node(char id, int ifr) {
			this.data = id;
			this.freq = ifr;
			this.left = null;
			this.right = null;
		}

		@Override
		public int compareTo(Node other) {
			if (this.freq < other.freq) {
				return -1;
			} else if (this.freq > other.freq) {
				return 1;
			} else {
				return 1; // If equal frequencies
			}
		}
	}

	static class HuffmanEncoder {
		HashMap<Character, String> encoder = new HashMap<>();
		HashMap<String, Character> decoder = new HashMap<>();

		HuffmanEncoder(String feeder) {
			// prepare
			// Make Frequency array
			HashMap<Character, Integer> freqmap = new HashMap<>();
			for (int i = 0; i < feeder.length(); i++) {
				char cc = feeder.charAt(i);
				if (freqmap.containsKey(cc)) {
					freqmap.put(cc, freqmap.get(cc) + 1);
				} else {
					freqmap.put(cc, 1);
				}
			}
			// Make PQ
			PriorityQueue<Node> pq = new PriorityQueue<>();
			for (Character key : freqmap.keySet()) {
				Node node = new Node(key, freqmap.get(key));
				pq.add(node);
			}
			// tree root
			while (pq.size() > 1) {
				Node n1 = pq.remove();
				Node n2 = pq.remove();
				Node newNode = new Node('$', n1.freq + n2.freq);
				newNode.left = n1;
				newNode.right = n2;
				pq.add(newNode);
			}
			// get root node
			Node root = pq.peek();
			pq.remove();
			// traverse and fill encoder and decoder
			traverse(root, "");
		}

		void traverse(Node root, String psf) {
			if (root == null) {
				return;
			}
			// Root Node
			if (root.left == null && root.right == null) {
				encoder.put(root.data, psf);
				decoder.put(psf, root.data);
				return;
			}
			traverse(root.left, psf + "0");
			traverse(root.right, psf + "1");
		}

		String encode(String str) { // example -> 'ABCD' : 01.100.111.10001
			String s = "";
			for (int i = 0; i < str.length(); i++) {
				char cc = str.charAt(i);
				s += encoder.get(cc);
			}
			return s;
		}

		String decode(String str) {
			String s = "";
			String result = "";
			for (int i = 0; i < str.length(); i++) {
				s += str.charAt(i);
				if (decoder.containsKey(s)) {
					result += decoder.get(s);
					s = "";
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		String str = "aaaabbccdd";
		HuffmanEncoder he = new HuffmanEncoder("aaaabbccdd");
		for (char key : he.encoder.keySet()) {
			System.out.println(key + " " + he.encoder.get(key));
		}
		System.out.println();
		for (String key : he.decoder.keySet()) {
			System.out.println(key + " " + he.decoder.get(key));
		}
		System.out.println();
		System.out.println(he.encode(str));
		System.out.println(he.decode("00001101101010111111"));
	}

}

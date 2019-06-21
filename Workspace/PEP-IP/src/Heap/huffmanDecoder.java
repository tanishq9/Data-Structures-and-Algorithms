package Heap;

import java.util.HashMap;

public class huffmanDecoder {
	static HashMap<String, String> decoder = new HashMap<>();

	static class minHeapNode {
		char data;
		int freq;
		minHeapNode left, right;

		minHeapNode(char data, int freq) {
			left = right = null;
			this.data = data;
			this.freq = freq;
		}
	}

	static String decodeString(minHeapNode root, String str) {
		build(root, "");
		String s = "";
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			s += str.charAt(i);
			if (decoder.containsKey(s)) {
				res += decoder.get(s);
				s = "";
			}
		}
		return res;
	}

	static void build(minHeapNode root, String psf) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			decoder.put(psf, root.data + "");
			return;
		}
		build(root.left, psf + "0");
		build(root.right, psf + "1");
	}
}

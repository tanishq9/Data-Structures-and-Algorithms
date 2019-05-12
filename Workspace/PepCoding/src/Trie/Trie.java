package Trie;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {

	static class Node {
		char data;
		boolean eow;
		HashMap<Character, Node> cmap;

		Node(char data, boolean eow) {
			this.data = data;
			this.eow = eow;
			this.cmap = new HashMap<>();
		}
	}

	static void addWord(Node root, String word) {
		if (word.length() == 0) {
			root.eow = true;
			return;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		if (root.cmap.containsKey(cc)) {
			Node oldChild = root.cmap.get(cc);
			addWord(oldChild, ros);
		} else {
			Node newChild = new Node(cc, false);
			root.cmap.put(cc, newChild);
			addWord(newChild, ros);
		}
	}

	static void removeWord(Node root, String word) {
		if (word.length() == 0) {
			root.eow = false;
			return;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = root.cmap.get(cc);
		removeWord(child, ros);
		// Post Work : Not a terminal character of a word, Not a part of any word
		if (child.eow == false && child.cmap.size() == 0) {
			root.cmap.remove(cc);
		}
	}

	static boolean searchWord(Node root, String word) {
		if (word.length() == 0) {
			return root.eow;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		if (root.cmap.containsKey(cc)) {
			Node child = root.cmap.get(cc);
			if (searchWord(child, ros)) {
				return true;
			}
		}
		return false;
	}

	static void diplayastree(Node root) {
		System.out.print(root.data + "->");
		ArrayList<Character> children = new ArrayList<>(root.cmap.keySet());
		for (int i = 0; i < children.size(); i++) {
			char cc = children.get(i);
			System.out.print(cc + ",");
		}
		System.out.println(".");
		for (int i = 0; i < children.size(); i++) {
			char cc = children.get(i);
			Node child = root.cmap.get(cc);
			diplayastree(child);
		}
	}

	static void display(Node root, String asf) {
		if (root.eow == true) {
			System.out.println(asf);
		}
		ArrayList<Character> children = new ArrayList<>(root.cmap.keySet());
		for (int i = 0; i < children.size(); i++) {
			char cc = children.get(i);
			Node childNode = root.cmap.get(cc);
			display(childNode, asf + cc);
		}
	}

	public static void main(String[] args) {
		String[] words = { "are", "art", "as", "ask", "ant", "an", "and", "seen", "see", "sea" };
		Node root = new Node('$', false);
		for (int i = 0; i < words.length; i++) {
			addWord(root, words[i].trim().toLowerCase());
		}
		display(root, "");
		System.out.println();
		System.out.println(searchWord(root, "are"));
		System.out.println(searchWord(root, "cart"));
		System.out.println();
		diplayastree(root);
		removeWord(root, "as");
		removeWord(root, "ask");
		removeWord(root, "and");
		removeWord(root, "an");
		System.out.println();
		diplayastree(root);
	}

}

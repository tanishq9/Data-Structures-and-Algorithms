package Strings;

import java.util.HashMap;

public class PatternMatchingUsingTrie {

	private class TrieNode {
		Character data;
		HashMap<Character, TrieNode> children;
		Boolean isTerminal;

		TrieNode(Character d) {
			this.data = d;
			this.isTerminal = false;
		}
	}
	
	public void addNode(String word) {
		
	}

	public static void main(String[] args) {

	}

}

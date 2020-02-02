package one;

import java.util.HashMap;

public class Trie {
	private class Node{
		char data;
		HashMap<Character,Node> children;
		boolean isTerminal;
		
		Node(char data,boolean isTerminal){
			this.data=data;
			this.isTerminal=isTerminal;
		}
	}

	private int numWords;
	private Node root;
	Trie(){
		this.root=new Node('\0',false);
		this.numWords=0;
	}
	public void addWord(String word) {
		this.addWord(this.root,word);
	}
	private void addWord(Node parent,String word) {
		
		if(word.length()==0) {
			if(parent.isTerminal) {
				//Word already exists
			}else {
				parent.isTerminal=true;
				this.numWords++;
			}
		}
		char cc=word.charAt(0);
		String ros=word.substring(1);
		Node child=parent.children.get(cc);
		if(child==null) {
			child=new Node(cc,false);
			parent.children.put(cc,child);
		}
		this.addWord(child,ros);
	};
	public boolean searchWord(String word) {
		return this.searchWord(this.root,word);
	}
	private boolean searchWord(Node parent,String word) {
		if(word.length()==0) {
			if(parent.isTerminal==true) {
				return true;
			}
		}
		char cc=word.charAt(0);
		String ros=word.substring(1);
		Node child=parent.children.get(cc);
		if(child==null) {
			return false;
		}
		return this.searchWord(child,ros);
	}
	public void removeWord(String word) {
		this.removeWord(this.root,word);
	}
	private void removeWord(Node parent,String word) {
		if(word.length()==0) {
			if(parent.isTerminal) {
				parent.isTerminal=false;
				this.numWords--;
				//the reason for setting it to false is that only once for the word we will set isterminal to false
				return;
			}else {
				
			}
		}
		char cc=word.charAt(0);
		String ros=word.substring(1);
		Node child=parent.children.get(cc);
		if(child==null) {
			return;
		}
		removeWord(child,ros);
		if(!child.isTerminal && child.children.size()==0) {
			parent.children.get(child)
;		}
	}
}

package LinkedList;

import java.util.PriorityQueue;

public class mergeKSorted {
	// Class declaration for a Node of the Linked List
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	static class tr implements Comparable<tr> {
		Node node;

		tr(Node inode) {
			this.node = inode;
		}

		public int compareTo(tr other) {
			if (this.node.data < other.node.data) {
				return -1;
			} else if (this.node.data > other.node.data) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public static Node mergeKList(Node[] arr, int k) {
		PriorityQueue<tr> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			pq.add(new tr(arr[i]));
		}
		Node root = pq.peek().node;
		Node temp = root;
		while (pq.size() > 0) {
			// Get
			tr top = pq.peek();
			// Remove
			pq.remove();
			// Connect nodes
			if (top.node != root) {
				temp.next = top.node;
				temp = temp.next;
			}
			// Add the new nodes
			if (top.node.next != null) {
				pq.add(new tr(top.node.next));
			}
		}
		return root;
	}
}

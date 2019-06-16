package LinkedList;

public class insertInSortedLL {
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node sortedInsert(Node head, int key) {
		// Empty List
		if (head == null) {
			Node newNode = new Node(key);
			newNode.next = null;
			head = newNode;
			return head;
		}
		// At the start
		if (key < head.data) {
			Node newNode = new Node(key);
			newNode.next = head;
			head = newNode;
			return head;
		}
		// In between an end
		Node current = head;
		while (current.next != null && current.next.data < key) {
			current = current.next;
		}
		Node newNode = new Node(key);
		newNode.next = current.next;
		current.next = newNode;
		return head;
	}
}

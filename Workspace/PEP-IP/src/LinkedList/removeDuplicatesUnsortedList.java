package LinkedList;

import java.util.HashSet;
import java.util.Scanner;

public class removeDuplicatesUnsortedList {
	public static Node removeDuplicates(Node head) {
		HashSet<Integer> set = new HashSet<>();
		Node curr = head;
		set.add(curr.data);
		while (curr.next != null) {
			if (set.contains(curr.next.data)) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
				set.add(curr.data);
			}
		}
		return head;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		head = insert(head, a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			head = insert(head, a);
		}

		head = removeDuplicates(head);
		display(head);

	}

	// Class declaration for a Node of the Linked List
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	static Node head;

	static Node head2;

	static Node head3;

	/*
	 * Input Parameters: head: head of the linked list in which a new node is to be
	 * inserted. data: the data value of the node which is to be inserted.
	 * 
	 * Return Value: head of the linked list in which the node is inserted
	 */
	public static Node insert(Node head, int data) {

		if (head == null) {
			return new Node(data);
		}

		head.next = insert(head.next, data);
		return head;
	}

	/*
	 * Input Parameters: head: head of the linked list in which is to be displayed.
	 * 
	 * Return Value: null
	 */
	public static void display(Node head) {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}
}

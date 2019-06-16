package LinkedList;

import java.util.Scanner;

public class reverseSubList {

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input the head of the linked list, m and n.
	// It should return the head of the modified list.

	private static Node rev(Node start, Node end) {
		Node prev = null;
		Node curr = start;
		Node n = start.next;
		while (prev != end) {
			curr.next = prev;
			prev = curr;
			curr = n;
			if (n != null) {
				n = n.next;
			}
		}
		return prev;
	}

	public static Node reverseBetween(Node head, int m, int n) {
		// write your code here
		// Get all the pointers required for range reversing
		Node rs = null, re = null, bs = null, ae = null;
		Node temp = head;
		int i = 1;
		while (temp != null) {
			if (i < m) {
				bs = temp;
			} else if (i == m) {
				rs = temp;
			} else if (i == n) {
				re = temp;
				ae = temp.next;
			}
			temp = temp.next;
			i++;
		}
		// Check if the range started from 1 or not
		if (bs == null) {
			head = rev(rs, re);
		} else {
			bs.next = rev(rs, re);
		}
		rs.next = ae;
		return head;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int a1 = sc.nextInt();
		head1 = insert(head1, a1);

		for (int i = 1; i < n1; i++) {
			int a = sc.nextInt();
			head1 = insert(head1, a);
		}

		int m = sc.nextInt();
		int n = sc.nextInt();
		head1 = reverseBetween(head1, m, n);
		display(head1);

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

	static Node head1;

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

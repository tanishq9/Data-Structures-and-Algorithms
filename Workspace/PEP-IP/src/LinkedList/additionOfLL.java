package LinkedList;

public class additionOfLL {
	// Class declaration for a Node of the Linked List
	private static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	public static Node addTwoNumbers(Node n1, Node n2) {
		n1 = rev(n1);
		n2 = rev(n2);
		int sum = 0;
		int carry = 0;
		Node head = null;
		Node prev = null;
		while (n1 != null && n2 != null) {
			sum = n1.data + n2.data + carry;
			carry = sum / 10;
			sum = sum % 10;
			if (head == null) {
				Node newNode = new Node(sum, null);
				head = newNode;
				prev = newNode;
			} else {
				Node newNode = new Node(sum, null);
				prev.next = newNode;
				prev = newNode;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		while (n1 != null) {
			sum = n1.data + carry;
			carry = sum / 10;
			sum = sum % 10;
			Node newNode = new Node(sum, null);
			prev.next = newNode;
			prev = newNode;
			n1 = n1.next;
		}
		while (n2 != null) {
			sum = n2.data + carry;
			carry = sum / 10;
			sum = sum % 10;
			Node newNode = new Node(sum, null);
			prev.next = newNode;
			prev = newNode;
			n2 = n2.next;
		}
		if (carry != 0) {
			Node newNode = new Node(carry, null);
			prev.next = newNode;
			prev = newNode;
		}
		return rev(head);
	}

	static Node rev(Node head) {
		Node prev = null;
		Node curr = head;
		while (curr != null) {
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

}

package LinkedList;

public class addOneToLL {
	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public static Node plusOne(Node n) {
		n = rev(n);
		int sum = 0;
		int carry = 0;
		Node head = null;
		Node prev = null;
		sum = n.data + 1;
		carry = sum / 10;
		sum = sum % 10;
		if (head == null) {
			Node newNode = new Node(sum);
			head = newNode;
			prev = newNode;
		}
		n = n.next;

		while (n != null) {
			sum = n.data + carry;
			carry = sum / 10;
			sum = sum % 10;
			Node newNode = new Node(sum);
			prev.next = newNode;
			prev = newNode;
			n = n.next;
		}
		if (carry != 0) {
			Node newNode = new Node(carry);
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

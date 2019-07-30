package LinkedList;

public class removeLoopInSinglyLL {
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public static void removeTheLoop(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (slow != fast) {
			return;
		}
		// For whole list being a cycle
		if (slow == head) {
			while (fast.next != slow) {
				fast = fast.next;
			}
			fast.next = null;
		} else { // For list containing a cycle
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}

	}

}

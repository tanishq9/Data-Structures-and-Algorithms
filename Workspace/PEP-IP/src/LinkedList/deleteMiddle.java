package LinkedList;

public class deleteMiddle {
	Node Delete(Node head) {
		Node slow = head;
		Node fast = head;
		Node prev = null;
		if (fast.next == null) {
			return null;
		}
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = slow.next;
		slow.next = null;
		return head;
	}
}

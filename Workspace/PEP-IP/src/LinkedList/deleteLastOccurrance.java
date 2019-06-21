package LinkedList;

public class deleteLastOccurrance {
	public static Node func(Node head, int key) {
		Node prev = null;
		Node curr = head;
		while (curr != null) {
			if (curr.next != null && curr.next.data == key) {
				prev = curr;
			}
			curr = curr.next;
		}
		if (prev == null && head.data == key) {
			head = head.next;
			return head;
		}
		if (prev != null) {
			prev.next = prev.next.next;
		}
		return head;
	}
}

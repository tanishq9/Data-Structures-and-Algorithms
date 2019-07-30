package LinkedList;

public class partitionLL {
	public static Node partition(Node head, int x) {
		// write your code here.

		Node before_head = null;
		Node after_head = null;
		Node before_end = null;
		Node after_end = null;

		Node temp = head;

		while (temp != null) {
			if (temp.data < x) {
				if (before_head == null) {
					before_head = temp;
					before_end = temp;
				} else {
					before_end.next = temp;
					before_end = temp;
				}
			} else {
				if (after_head == null) {
					after_head = temp;
					after_end = temp;
				} else {
					after_end.next = temp;
					after_end = temp;
				}
			}
			temp = temp.next;
		}
		if (before_head == null || after_head == null) {
			return head;
		} else {
			before_end.next = after_head;
			head = before_head;
			after_end.next = null;
			return head;
		}
	}
}

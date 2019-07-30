package LinkedList;

public class inplaceLLRearrangement {
	public static Node rearrange(Node head) {
		Node prev = null;
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		// Find heads for 2 lists
		Node head1 = head;
		Node head2 = null;
		if (fast == null) {
			head2 = slow;
			prev.next = null;
		} else {
			head2 = slow.next;
			slow.next = null;
		}
		// Reverse second list
		head2 = rev(head2);
		// Alternatively merge the 2 lists
		boolean flag = true;
		while (head1 != null && head2 != null) {
			if (flag == true) {
				Node temp = head1.next;
				head1.next = head2;
				head1 = temp;
			} else {
				Node temp = head2.next;
				head2.next = head1;
				head2 = temp;
			}
			flag = !flag;
		}
		return head;
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

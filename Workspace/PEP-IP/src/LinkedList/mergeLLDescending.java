package LinkedList;

public class mergeLLDescending {
	static Node rev(Node head) {
		Node prev = head;
		Node curr = prev.next;
		while (curr != null) {
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	public static Node mergeResult(Node head1, Node head2) {
		Node rev1 = rev(head1);
		head1.next = null; // head1 is the new tail of the list
		Node rev2 = rev(head2);
		head2.next = null; // head2 is the new tail of the list
		return merge(rev1, rev2);
	}

	static Node merge(Node head1, Node head2) {
		// Descending
		Node new_head = null, sortptr = null;
		if (head1.data > head2.data) {
			new_head = head1;
			sortptr = head1;
			head1 = sortptr.next;
		} else {
			new_head = head2;
			sortptr = head2;
			head2 = sortptr.next;
		}
		while (head1 != null && head2 != null) {
			if (head1.data > head2.data) {
				sortptr.next = head1;
				sortptr = head1;
				head1 = sortptr.next;
			} else {
				sortptr.next = head2;
				sortptr = head2;
				head2 = sortptr.next;
			}
		}
		if (head1 == null) {
			sortptr.next = head2;
		} else if (head2 == null) {
			sortptr.next = head1;
		}
		return new_head;
	}
}

package LinkedList;

import LinkedList.LinkedList.Node;

public class Merge2ListsInPlace {
	// https://www.youtube.com/watch?v=j_UNYW6Ap0k
	public Node mergeSortedList(Node head1, Node head2, Node sorting) {
		Node new_head = null;
		if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}
		if (head1.data <= head2.data) {
			new_head = head1;
			sorting = head1;
			head1 = sorting.next;
		} else {
			new_head = head2;
			sorting = head2;
			head2 = sorting.next;
		}
		while (head1 != null && head2 != null) {
			if (head1.data <= head2.data) {
				sorting.next = head1;
				sorting = head1;
				head1 = sorting.next;
			} else {
				sorting.next = head2;
				sorting = head2;
				head2 = sorting.next;
			}
		}
		if (head1 == null) {
			sorting.next = head2;
		} else if (head2 == null) {
			sorting.next = head1;
		}
		return new_head;
	}

}

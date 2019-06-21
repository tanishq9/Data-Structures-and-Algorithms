package LinkedList;

public class circularLLsplitIn2Halves {
	public static Node[] splitList(Node head) {
		Node[] arr = new Node[2];
		Node head1 = null;
		Node head2 = null;
		if (head.next == head) {
			head1 = head;
			head2 = null;
			arr[0] = head1;
			arr[1] = head2;
			return arr;
		}
		Node slow = head;
		Node fast = head;
		while (fast.next != head && fast.next.next != head) {
			slow = slow.next;
			fast = fast.next.next;
		}
		head1 = head;
		head2 = slow.next;
		slow.next = head;
		if (fast.next.next == head) {
			fast.next.next = head2;
		} else {
			fast.next = head2;
		}
		arr[0] = head1;
		arr[1] = head2;
		return arr;
	}
}

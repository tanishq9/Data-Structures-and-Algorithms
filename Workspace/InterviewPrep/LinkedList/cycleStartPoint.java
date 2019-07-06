package LinkedList;

public class cycleStartPoint {
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public static Node detectCycle(Node head) {
		Node s = head;
		Node f = head;
		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
			if (s == f) {
				break;
			}
		}
		// if cycle starts at head node
		if (s == head) {
			return head;
		}
		s = head;
		while (s.next != f.next) {
			s = s.next;
			f = f.next;
		}
		return f.next;
	}
}

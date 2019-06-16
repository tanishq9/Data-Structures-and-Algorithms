package LinkedList;

import LinkedList.cycleStartPoint.Node;

public class numberOfNodesInLoop {
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public static int countNodesInLoop(Node head) {
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
		Node sp = null;
		if (s == head) {
			sp = s;
		} else { // else cycle somewhere within list
			s = head;
			while (s.next != f.next) {
				s = s.next;
				f = f.next;
			}
			sp = f.next;
		}
		// Node traverse the cycle and compute the length
		int len = 1;
		s = sp.next;
		while (s != sp) {
			s = s.next;
			len++;
		}
		return len;
	}

}

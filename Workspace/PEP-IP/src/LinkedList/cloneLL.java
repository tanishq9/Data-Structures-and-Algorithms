package LinkedList;

class Node {
	int data;
	Node next, arb;

	Node(int d) {
		next = arb = null;

	}
}

public class cloneLL {
	class Clone {
		Node copyList(Node head) {
			Node curr = head, temp = null;
			// Insert Nodes
			while (curr != null) {
				temp = curr.next;
				curr.next = new Node(curr.data);
				curr.next.next = temp;
				curr = temp;
			}
			curr = head;
			// Assign random pointers
			while (curr != null) {
				if (curr.next != null) {
					curr.next.arb = (curr.arb != null) ? curr.arb.next : curr.arb;
				}
				curr = (curr.next != null) ? curr.next.next : curr.next;
			}
			// Restore original list
			curr = head;
			Node cpyhead = head.next;
			temp = cpyhead;
			while (curr != null && temp != null) {
				curr.next = curr.next != null ? curr.next.next : curr.next;
				temp.next = temp.next != null ? temp.next.next : temp.next;
				curr = curr.next;
				temp = temp.next;
			}
			return cpyhead;
		}
	}
}

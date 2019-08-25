package LinkedList;

public class floydCycle {

	private static class Node {
		int data;
		Node next;

		Node(int idata) {
			this.data = idata;
			this.next = null;
		}
	}

	public static void display(Node node) {
		Node head = node;
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static boolean isloop(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public static int removeLoop(Node head) {
		Node slow = head;
		Node fast = head;
		Node prev = null;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				prev = slow;
				break;
			}
		}
		slow = head;
		fast = prev;
		while (fast != slow) {
			prev = fast;
			slow = slow.next;
			fast = fast.next;
		}
		System.out.println("Loop starting node : " + slow.data);

		prev.next = null;
		return slow.data;
	}

	public static int intersectionPoint(Node head1, Node head2) {
		Node tail1 = head1;
		while (tail1.next != null) {
			tail1 = tail1.next;
		}
		tail1.next = head2;
		return removeLoop(head1);
	}

	public static void main(String[] args) {
		// Floyd_Cycle
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		Node n9 = new Node(90);
		Node n10 = new Node(100);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = null;

		n10.next = n5;

		if (isloop(n1)) {
			System.out.println("Loop Detected.");
			removeLoop(n1);
			display(n1);
		} else {
			System.out.println("No Loop.");
		}

		// Intersection
		Node m1 = new Node(10);
		Node m2 = new Node(20);
		Node m3 = new Node(30);
		Node m4 = new Node(40);
		Node m5 = new Node(50);
		Node m6 = new Node(60);

		m1.next = m2;
		m2.next = m3;
		m3.next = n4;
		m4.next = m5;
		m5.next = m6;
		m6.next = null;

		System.out.println(intersectionPoint(n1, m1));

	}

}

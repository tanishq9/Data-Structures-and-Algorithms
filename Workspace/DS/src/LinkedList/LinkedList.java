package LinkedList;

public class LinkedList {
	class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node head;
	Node tail;
	int size;

	LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void addFirst(int data) {
		Node node = new Node(data, this.head);
		this.head = node;
		if (this.isEmpty()) {
			// agar list khali hai
			this.tail = node;
		}
		this.size++;
	}

	public void addLast(int data) {
		Node node = new Node(data, null);
		// agar list khali hai
		if (isEmpty()) {
			this.tail = node;
			this.head = node;
		} else {
			// agar list khali nahi hai
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}

	public void addAt(int value, int index) throws Exception {
		if (index < 0 || index > this.size) {
			throw new Exception("Invalid index");
		}
		if (index == 0) {
			this.addFirst(value);
			return;
		}
		if (index == this.size) {
			this.addLast(value);
			return;
		} else {
			Node temp = getNode(index - 1);
			Node newNode = new Node(value, temp.next);
			temp.next = newNode;
			this.size++;
		}
	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		return this.tail.data;
	}

	public int getNodeAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}
		return getNode(index).data;
	}

	public Node getNode(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid Index");
		}
		Node temp = this.head;
		int counter = 0;
		while (counter < index) {
			temp = temp.next;
			counter++;
		}
		return temp;
	}

	public void removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node temp = this.head.next;
			this.head.next = null;
			this.head = temp;
		}
		this.size--;
	}

	public void removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node temp = getNode(this.size - 2);
			temp.next = null;
			this.tail = temp;
			this.size--;
		}
	}

	public void removeAt(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid Index");
		}
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		if (index == 0) {
			this.removeFirst();
		} else if (index == this.size - 1) {
			this.removeLast();
		} else {
			Node temp = getNode(index - 1);
			temp.next = temp.next.next;
			this.size--;
		}
	}

	public void reverseDI() throws Exception {
		int left = 0, right = this.size - 1;
		while (left <= right) {
			Node l = getNode(left);
			Node r = getNode(right);
			int temp = l.data;
			l.data = r.data;
			r.data = temp;
			left++;
			right--;
		}
	}

	public void reverseDR() throws Exception {

		// Node left = this.head;
		// Node right = this.head;

		HeapMover heapMover = new HeapMover(this.head);
		// reverseDR2(heapMover, this.head, 0);
		reverseDR(heapMover, this.head, 0);
	}

	private void reverseDR(HeapMover left, Node right, int level) {
		if (right == null) {
			return;
		}
		reverseDR(left, right.next, level + 1);
		if (level >= this.size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
			left.node = left.node.next;
		}
	}

	private void reverseDR2(Node left, Node right, int level) {
		if (right == null) {
			return;
		}
		reverseDR2(left, right.next, level + 1);
		if (level >= this.size / 2) {
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
			left = left.next;
		}
	}

	public void reversePR() {
		reversePR(this.head);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reversePR(Node node) {
		if (node == this.tail) {
			return;
		}
		reversePR(node.next);
		node.next.next = node;
	}

	public void reversePI() {
		Node prev = this.head;
		Node curr = prev.next;
		while (curr != null) {
			Node tempcurr = curr;
			Node tempprev = prev;
			prev = curr;
			curr = curr.next;
			tempcurr.next = tempprev;
		}
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private class HeapMover {
		Node node;

		HeapMover(Node node) {
			this.node = node;
		}
	}

	public void floydCycle() {
		Node slow = this.head;
		Node fast = slow;
		Node loop_end = null;
		boolean loop_found = false;
		while (fast.next != null && fast.next.next != null) {
			if (loop_found == false) {
				slow = slow.next;
				fast = fast.next.next;
				if (fast == slow) {
					// Now find beginning of that loop
					System.out.println("Loop Found.");
					loop_found = true;
				}
			}
			if (loop_found == true) {
				slow = slow.next;
				fast = fast.next;
				if (fast == slow && loop_end == null) {
					// Now remove that loop
					System.out.println("Loop Begin Detected.");
					loop_end = slow;
				} else {
					while (loop_end.next != fast) {
						loop_end = loop_end.next;
					}
					loop_end.next = null;
					System.out.println("Loop removed.");
					return;
				}
			}
		}
		System.out.println("Loop doesn't exists.");
		return;
	}

	public Node getMidNode() {
		Node fast = this.head;
		Node slow = this.head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public void mergeSortLL() {
		LinkedList sorted = mergeSorthelperLL(this.head, this.tail);
		this.head = sorted.head;
		this.tail = sorted.tail;
		this.size = sorted.size;
	}

	private LinkedList mergeSorthelperLL(Node lo, Node hi) {
		if (this.size == 1) {
			return this;
		}
		Node mid = getMidNode();
		Node midnext = mid.next;
		mid.next = null;
		LinkedList L1 = new LinkedList(lo, mid, (this.size + 1) / 2);
		LinkedList L2 = new LinkedList(midnext, hi, this.size / 2);
		L1.mergeSortLL();
		L2.mergeSortLL();
		return merge(L1, L2);
	}

	private LinkedList merge(LinkedList l1, LinkedList l2) {
		Node headOne = l1.head;
		Node headTwo = l2.head;
		LinkedList ll = new LinkedList();
		while (headOne != null && headTwo != null) { // jabtak dono null ko point nahi kar rahe tab tak
			if (headOne.data < headTwo.data) {
				ll.addLast(headOne.data);
				headOne = headOne.next;
			} else {
				ll.addLast(headTwo.data);
				headTwo = headTwo.next;
			}
		}
		while (headOne != null) {
			ll.addLast(headOne.data);
			headOne = headOne.next;
		}
		while (headTwo != null) {
			ll.addLast(headTwo.data);
			headTwo = headTwo.next;
		}
		return ll;
	}

	private LinkedList(Node head, Node tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	public void reverseKsize(int k) throws Exception {
		reverseKsize(this.head, k);
	}

	Node getNode2(int index) {
		int count = 0;
		Node temp = this.head;
		while (count < index) {
			count++;
			temp = temp.next;
		}
		return temp;
	}

	private void reverseKsize(Node node, int k) throws Exception {
		int left = 0, right = k;
		int iter = this.size() / k;

		while (left <= right) {
			Node l = getNode2(left);
			Node r = getNode2(right);
			int temp = l.data;
			l.data = r.data;
			r.data = temp;
			left++;
			right--;
		}
		k += iter;
	}

	private void pairWiseRecur() {
		pairWiseRecur(this.head);
	}

	public void pairWiseRecur(Node temp) {
		while (temp != null && temp.next != null) {
			int t = temp.data;
			temp.data = temp.next.data;
			temp.next.data = t;
			pairWiseRecur(temp.next.next);
		}
	}

	public void pairWiseSwap() {
		Node temp = this.head;
		// traverse further only if there are 2 nodes left
		while (temp != null && temp.next != null) {
			// swap data with its next node's data
			int t = temp.data;
			temp.data = temp.next.data;
			temp.next.data = t;
			// move temp by 2 for the next pair
			temp = temp.next.next;
		}
	}

	

}

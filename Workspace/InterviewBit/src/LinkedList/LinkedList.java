package LinkedList;

import java.util.HashSet;
import java.util.Stack;

public class LinkedList {

	class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

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
			this.tail = node;
		}
		this.size++;
	}

	public void addLast(int data) {
		Node node = new Node(data, null);
		if (this.isEmpty()) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}

	public void addAt(int data, int index) throws Exception {
		if (index < 0 || index > this.size) {
			throw new Exception("Invalid Index");
		} else if (index == 0) {
			this.addFirst(data);
		} else if (index == (this.size - 1)) {
			this.addLast(data);
		} else {
			Node prevNode = getNodeAt(index - 1);
			Node newNode = new Node(data, prevNode.next);
			prevNode.next = newNode;
			this.size++;
		}
	}

	public Node getFirst() {
		return this.head;
	}

	public Node getLast() {
		return this.tail;
	}

	public Node getNodeAt(int index) {
		Node temp = this.head;
		int currentIndex = 0;
		while (currentIndex < index) {
			temp = temp.next;
			currentIndex++;
		}
		return temp;
	}

	public void removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		} else if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			Node temp = this.head.next;
			this.head.next = null;
			this.head = temp;
			this.size--;
		}

	}

	public void removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		} else if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			Node temp = getNodeAt(this.size - 2);
			temp.next = null;
			this.tail = temp;
			this.size--;
		}
	}

	public void removeAt(int index) throws Exception {
		if (isEmpty()) {
			throw new Exception("List is Empty");
		} else if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else if (index == 0) {
			this.removeFirst();
		} else if (index == (this.size - 1)) {
			this.removeLast();
		} else {
			Node temp = getNodeAt(index - 1);
			temp.next = temp.next.next;
			this.size--;
		}
	}

	public boolean IsPalindromeUsingStack() {
		return IsPalindromeUsingStack(this.head);
	}

	private boolean IsPalindromeUsingStack(Node node) {
		Stack<Integer> stack = new Stack<>();
		Node temp = node;
		while (temp != null) {
			stack.push(temp.data);
			temp = temp.next;
		}
		temp = node;
		while (temp != null) {
			if (temp.data == stack.peek()) {

			} else {
				return false;
			}
			stack.pop();
			temp = temp.next;
		}
		return true;
	}

	Node left;

	public boolean isPalindromeRecursively() {
		return isPalindromeRecursively(this.head);
	}

	private boolean isPalindromeRecursively(Node right) {
		left = this.head;
		if (right == null) {
			return true;
		}
		boolean ispdr = isPalindromeRecursively(right.next);
		if (ispdr == false) {
			return false;
		}
		ispdr = (right.data == left.data);
		left = left.next;
		return ispdr;
	}

	public Node removeNthNodeFromEnd(int n) {
		return removeNthNodeFromEnd(this.head, n);
	}

	private Node removeNthNodeFromEnd(Node node, int n) {

		// Get the length of the list
		int len = 0;
		Node temp = node;// node is pointing to the head of the list
		while (temp != null) {
			len++;
			temp = temp.next;
		}
		int nthFromStart = len - n + 1;
		temp = node;
		if (nthFromStart == 1) { // if it is first node from start
			return node.next;
		}
		// else not the head node
		int i = 0;
		while (temp != null) {
			i++;
			if (i == nthFromStart - 1) {
				temp.next = temp.next.next; // change pointer
			}
			temp = temp.next; // continue traversing
		}
		return node;
	}

	public void removeDuplicatesSorted() {
		removeDuplicatesSorted(this.head);
	}

	private void removeDuplicatesSorted(Node node) {
		while (node.next != null) {
			if (node.data == node.next.data) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
	}

	public void removeDuplicatesUnSorted() {
		removeDuplicatesUnSorted(this.head);
	}

	private void removeDuplicatesUnSorted(Node node) {
		HashSet<Integer> set = new HashSet<>();
		Node current = node;
		Node prev = null;
		while (current.next != null) {
			if (set.contains(current.data)) {
				prev.next = current.next;
			} else {
				prev = current;
				set.add(current.data);
			}
			current = current.next;
		}
	}

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

	public Node rotateList(int n) {
		return rotateList(this.head, n);
	}

	private Node rotateList(Node node, int n) {
		Node temp = node; // node is the head
		Node last = null;
		while (temp.next != null) {
			temp = temp.next;
		}
		last = temp;
		last.next = node;
		int i = 0;
		while (i < n) {
			i++;
			temp = temp.next;
		}
		node = temp.next;
		temp.next = null;
		return node;
	}

	public void floydCycle(Node node) {
		Node slow = node; // node is the head
		Node fast = node;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				slow = node;
				break;
			}
		}
		while (fast != slow) {
			slow = slow.next;
			fast = fast.next;
		}
		// Now both slow and fast are pointing to the beginning of the loop
		while (slow.next != fast) {
			slow = slow.next;
		}
		slow.next = null; // Loop removed
	}

	public void reverseListPR() {
		Node last = this.head;
		while (last.next != null) {
			last = last.next;
		}
		reverseListPR(this.head);
		Node temp = last;
		last = this.head;
		this.head = temp;
		last.next = null;
	}

	private void reverseListPR(Node node) {
		if (node.next == null) {
			return;
		}
		reverseListPR(node.next);
		node.next.next = node;
	}

	public Node getMid(Node node) {
		Node slow = node;
		Node fast = node;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public void mergeSort() {
		Node new_head = mergeSort(this.head);
		this.head = new_head;
	}

	private Node mergeSort(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		Node mid = getMid(node);
		Node nextToMid = mid.next;
		mid.next = null;
		Node left = mergeSort(node); // node points to the head of the linked list
		Node right = mergeSort(nextToMid);
		return mergeListInPlace(left, right);
	}

	private Node mergeListInPlace(Node left, Node right) {
		Node sortingPtr, new_head = null;
		if (left.data > right.data) {
			sortingPtr = right;
			new_head = right;
			right = sortingPtr.next;
		} else {
			sortingPtr = left;
			new_head = left;
			left = sortingPtr.next;
		}
		while (left != null && right != null) {
			if (left.data > right.data) {
				sortingPtr.next = right;
				sortingPtr = right;
				right = sortingPtr.next;
			} else {
				sortingPtr.next = left;
				sortingPtr = left;
				left = sortingPtr.next;
			}
		}
		if (left == null) {
			sortingPtr.next = right;
		} else if (right == null) {
			sortingPtr.next = left;
		}
		return new_head;
	}

	// the standard reverse function used
	// to reverse a linked list
	public Node reverseIteratively(Node node) {
		Node curr = node.next;
		Node prev = node;
		Node last = node;
		while (last.next != null) {
			last = last.next;
		}
		while (curr != null) {
			Node tempcurr = curr;
			Node tempprev = prev;
			prev = curr;
			curr = curr.next;
			tempcurr.next = tempprev;
		}
		return prev;
	}

	// function used to reverse a linked list
	// from position m to n which uses reverse
	// function
	public Node reverseKGroup(Node head, int m, int n) {
		// revs and revend is start and end respectively
		// of the portion of the linked list which
		// need to be reversed. revs_prev is previous
		// of starting position and revend_next is next
		// of end of list to be reversed.
		Node revs = null, revs_prev = null, rev_end = null, rev_end_next = null;
		Node temp = head;
		int i = 1;
		// Find values of above pointers.
		while (temp != null && i <= n) {
			if (i < m) {
				revs_prev = temp;
			}
			if (i == m) {
				revs = temp;
			}
			if (i == n) {
				rev_end = temp;
				rev_end_next = temp.next;
			}
			i++;
			temp = temp.next;
		}
		rev_end.next = null;
		// Reverse linked list starting with revs
		rev_end = reverseIteratively(revs);
		// If starting position was not head
		if (revs_prev != null) {
			revs_prev.next = rev_end;
		} // If starting position was head
		else {
			head = revs;
		}
		revs.next = rev_end_next;
		return head;
	}

	public void display() {
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("END");
	}

}

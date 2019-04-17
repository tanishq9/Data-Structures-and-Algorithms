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

	private Node getNodeAtIndex(int index) {
		Node temp = this.head;
		int current = 0;
		while (current < index) {
			current++;
			temp = temp.next;
		}
		return temp;
	}

	public void reverseDI() {
		int l = 0, r = this.size - 1;
		while (l < r) {
			Node left = getNodeAtIndex(l);
			Node right = getNodeAtIndex(r);
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
			l++;
			r--;
		}
	}

	public void reversePI() {
		Node prev = null;
		Node curr = this.head;
		Node n = this.head.next;
		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = n;
			if (n != null) {
				n = n.next;
			}
		}
		Node temp = this.head; // Get the head node
		this.head = this.tail; // Change head to tail
		this.tail = temp; // Point that tail to head
		this.tail.next = null; // Point tail.next to null
	}

	public void displayReverse() {
		displayReverse(this.head);
		System.out.println();
	}

	private void displayReverse(Node temp) {
		if (temp == null) {
			return;
		}
		displayReverse(temp.next);
		System.out.print(temp.data + " ");
	}

	public void reversePR() {
		reversePR(this.head);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reversePR(Node node) {
		if (node.next == null) {
			return;
		}
		reversePR(node.next);
		node.next.next = node;
	}

	// RDR : By adding a data member to our LinkedList Class

	Node rdrLeft = null;

	public void reverseDR() {
		rdrLeft = this.head;
		reverseDR(this.head, 0);
	}

	private void reverseDR(Node right, int floor) {
		if (right == null) {
			return;
		}
		reverseDR(right.next, floor + 1);
		if (floor > this.size / 2) {
			int temp = rdrLeft.data;
			rdrLeft.data = right.data;
			right.data = temp;
			rdrLeft = rdrLeft.next;
		}
	}

	// Palin_drome : Using RDR Approach

	public boolean isPalindrome() {
		rdrLeft = this.head;
		return isPalindrome(this.head);
	}

	private boolean isPalindrome(Node right) {
		if (right == null) {
			return true;
		}
		boolean isPalin = isPalindrome(right.next);
		if (isPalin == false) {
			return false;
		} else {
			if (rdrLeft.data == right.data) {
				rdrLeft = rdrLeft.next;
				return true;
			} else {
				return false;
			}
		}
	}

	// Palin_drome Alternate way
	private boolean isPalin(Node right) {
		if (right == null) {
			return true;
		}
		boolean rr = isPalin(right.next);
		boolean mr = rr == true && rdrLeft.data == right.data;
		rdrLeft = rdrLeft.next;
		return mr;
	}

	public Node getMidNode(Node sp, Node ep) {
		Node slow = sp;
		Node fast = sp;
		while (fast != ep && fast.next != ep) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public int getMidNodeData() {
		return getMidNode(this.head, this.tail).data;
	}

	public void fold() {
		rdrLeft = this.head;
		// Node midNode = getMidNode();
		fold(this.head, 0);
		// this.tail = midNode;
		// this.tail.next = null;
	}

	private void fold(Node right, int floor) {
		if (right == null) {
			return;
		}
		fold(right.next, floor + 1);
		if (floor > this.size / 2) {
			Node temp = rdrLeft.next;
			rdrLeft.next = right;
			right.next = temp;
			rdrLeft = temp;
		} else if (floor == size / 2) {
			this.tail = right;
			this.tail.next = null;
			return;
		}
	}

	public void unfold() {
		unfold(this.head);
	}

	private void unfold(Node node) {
		if (node.next == null) {
			this.head = this.tail = node;
			return;
		} else if (node.next.next == null) {
			this.head = node;
			this.tail = node.next;
			return;
		}
		Node temp = node.next;
		unfold(node.next.next);
		// Add First
		node.next = this.head;
		this.head = node;
		// Add Last
		this.tail.next = temp;
		this.tail = temp;
		this.tail.next = null;
	}

	public void oddEven() {
		Node oddStart = null, oddEnd = null, evenStart = null, evenEnd = null;
		oddEven(this.head, oddStart, oddEnd, evenStart, evenEnd);
	}

	private void oddEven(Node node, Node oS, Node oE, Node eS, Node eE) {
		while (node != null) {
			if (node.data % 2 == 0) {
				if (eS == null) {
					eS = node;
					eE = node;
				} else {
					eE.next = node;
					eE = node;
				}
			} else {
				if (oS == null) {
					oS = node;
					oE = node;
				} else {
					oE.next = node;
					oE = node;
				}
			}
			node = node.next;
		}
		// Only Even
		if (oS == null) {
			this.head = eS;
			eE.next = null;
			this.tail = eE;
		}
		// Only Odd
		else if (eS == null) {
			this.head = oS;
			oE.next = null;
			this.tail = oE;
		}
		// Both even and odd
		else {
			this.head = oS;
			oE.next = eS;
			eE.next = null;
			this.tail = eE;
		}
	}

	public void removeDuplicates() {
		rDup(this.head);
	}

	private void rDup(Node node) {
		int currData = node.data;
		while (node.next != null) {
			if (node.next.data == currData) {
				node.next = node.next.next;
			} else {
				node = node.next;
				currData = node.data;
			}
		}
	}

	public void kReverse(int k) throws Exception {
		LinkedList temp = new LinkedList();
		LinkedList accumulator = new LinkedList();
		Node node = this.head;
		while (node != null) {
			int counter = k;
			while (counter != 0) {
				counter--;
				if (node != null) {
					temp.addFirst(node.data);
					this.removeFirst();
					node = node.next;
				}
			}
			if (accumulator.tail == null) {
				accumulator = temp;
			} else {
				accumulator.tail.next = temp.head;
			}
			while (temp.size() != 0) {
				temp.removeFirst();
			}
		}
	}

	public void deleteGreaterNodesRight() {
		reverseList(this.head);
		// this.display();
		reOrderListForRight(this.head);
		// this.display();
		reverseList(this.head);
		// this.display();
	}

	private void reverseList(Node node) {
		Node prev = null;
		Node curr = this.head;
		Node n = this.head.next;
		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = n;
			if (n != null) {
				n = n.next;
			}
		}
		this.head = prev;
	}

	private void reOrderListForRight(Node node) {
		int max = node.data;
		while (node.next != null) {
			if (Math.max(node.next.data, max) == max) {
				node.next = node.next.next;
			} else {
				max = node.data;
				node = node.next;
			}
		}
		this.tail = node;
	}

	public void rearrange() {
		rearrange(this.head);
	}

	private void rearrange(Node head) {
		Node evenStart = null, evenEnd = null, oddStart = null, oddEnd = null;
		Node temp = head;
		int index = 0;
		while (temp != null) {
			if (index % 2 == 0) {
				if (evenStart == null) {
					evenStart = temp;
					evenEnd = temp;
				} else {
					evenEnd.next = temp;
					evenEnd = temp;
				}
			} else {
				if (oddStart == null) {
					oddStart = temp;
					oddEnd = temp;
				} else {
					oddEnd.next = temp;
					oddEnd = temp;
				}
			}
			temp = temp.next;
			index++;
		}
		oddEnd.next = null;
		reverse(oddStart);
		oddStart.next = null;
		evenEnd.next = oddEnd;
	}

	private void reverse(Node node) {
		if (node.next == null) {
			return;
		}
		reverse(node.next);
		node.next.next = node;
	}

	@SuppressWarnings("unused")
	public Node mergeLists(Node left, Node right) {
		Node sptr = null;
		Node new_head = null;
		if (left.data > right.data) {
			sptr = right;
			right = sptr.next;
			new_head = sptr;
		} else {
			sptr = left;
			left = sptr.next;
			new_head = sptr;
		}
		while (left != null || right != null) {
			if (left.data < right.data) {
				sptr.next = left;
				sptr = left;
				left = sptr.next;
			} else {
				sptr.next = right;
				sptr = right;
				right = sptr.next;
			}
		}
		if (left == null) {
			sptr.next = right;
		} else {
			sptr.next = left;
		}
		return new_head;
	}

	public void removeLoop() {
		removeTheLoop(this.head);
	}

	public void removeTheLoop(Node head) {
		if (head == null) {
			return;
		}
		Node slow = head;
		Node fast = head;
		Node common = null;
		while (slow.next != null || fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				common = slow;
				break;
			}
		}
		if (common == null) {
			return;
		}
		Node h = head;
		Node merge_point = null;
		while (h != null) {
			if (h == common) {
				merge_point = h;
				break;
			}
			common = common.next;
			h = h.next;
		}

		Node prev = merge_point;

		while (prev.next != merge_point) {
			prev = prev.next;
		}
		if (prev.next != null) {
			prev.next = null;
		}
	}

	public int midNodeData() {
		return getMidNode(this.head).data;
	}

	private Node getMidNode(Node node) {
		Node slow = node;
		Node fast = node;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public int kthFromLast(int k) {
		Node n1 = this.head;
		Node n2 = this.head;
		int counter = k;
		while (counter != 0) {
			n1 = n1.next;
			counter--;
		}
		while (n1 != null) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n2.data;
	}

	// Add

	public LinkedList add(LinkedList other) {
		LinkedList result = new LinkedList();
		int final_carry = add(this.head, other.head, this.size(), other.size(), result);
		if (final_carry == 1) {
			result.addFirst(1);
		} else {
			// 0 : Do Nothing
		}
		return result;
	}

	private int add(Node head1, Node head2, int size1, int size2, LinkedList result) {
		int carry;
		if (size1 == 1 && size2 == 1) {
			int data = head1.data + head2.data;
			result.addFirst(data % 10);
			return data / 10;
		} else if (size1 > size2) {
			carry = add(head1.next, head2, size1 - 1, size2, result);
			int data = head1.data + carry;
			result.addLast(data % 10);
			return data / 10;
		} else if (size1 == size2) {
			carry = add(head1.next, head2.next, size1 - 1, size2 - 1, result);
			int data = carry + head1.data + head2.data;
			result.addFirst(data % 10);
			return data / 10;
		} else {
			carry = add(head1, head2.next, size1, size2 - 1, result);
			int data = head2.data + carry;
			result.addFirst(data % 10);
			return data / 10;
		}
	}

	public int maxPalindrome() {
		return maxPalindrome(this.head);
	}

	public int commonLength(Node a, Node b) {
		int count = 0;
		while (a != null && b != null) {
			if (a.data == b.data) {
				++count;
			} else {
				break;
			}
			a = a.next;
			b = b.next;
		}
		return count;
	}

	public int maxPalindrome(Node head) {
		if (head == null) {
			return 0;
		}
		int result = 0;
		Node prev = null, curr = head;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			// check for even length
			result = Math.max(result, 2 * commonLength(curr, next));
			// check for even length
			result = Math.max(result, 2 * commonLength(prev, next) + 1);
			prev = curr;
			curr = next;
		}
		return result;
	}

	// Multiply

	public LinkedList multiply(LinkedList other) {
		LinkedList result = new LinkedList();
		multiply(this.head, other.head, this.size(), other.size(), result);
		return result;
	}

	private int multiply(Node head1, Node head2, int size1, int size2, LinkedList result) {
		int carry;
		for (int i = 0; i < size2; i++) {

		}
		return 0;
	}

	public void merge2SortedLinkedLists(LinkedList ll1, LinkedList ll2) {
		Node head1 = ll1.head;
		Node head2 = ll2.head;
		while (head1 != null && head2 != null) {
			if (head1.data > head2.data) {
				this.addLast(head2.data);
				head2 = head2.next;
			} else {
				this.addLast(head1.data);
				head1 = head1.next;
			}
		}
		while (head2 != null) {
			this.addLast(head2.data);
			head2 = head2.next;
		}
		while (head1 != null) {
			this.addLast(head1.data);
			head1 = head1.next;
		}
	}

	private LinkedList mergeSort(Node head, Node tail) {
		if (head == tail) {
			LinkedList baseResult = new LinkedList();
			baseResult.addFirst(head.data);
			return baseResult;
		}
		Node midNode = getMidNode(head, tail);
		Node midNext = midNode.next;
		// midNode.next = null;
		LinkedList ll1 = mergeSort(head, midNode);
		LinkedList ll2 = mergeSort(midNext, tail);
		LinkedList result = new LinkedList();
		result.merge2SortedLinkedLists(ll1, ll2);
		return result;
	}

	public LinkedList mergeSort() {
		LinkedList result = mergeSort(this.head, this.tail);
		return result;
	}

}

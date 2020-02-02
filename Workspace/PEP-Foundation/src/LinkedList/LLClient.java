package LinkedList;

public class LLClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		// Adding Functions
		l.addLast(1);
		l.addLast(1);
		l.addLast(1);
		l.addLast(2);
		l.addLast(2);
		l.addLast(3);
		l.addLast(4);
		l.addLast(5);
		l.addLast(5);
		l.addLast(5);
		l.addLast(4);
		l.addLast(3);
		/*
		 * System.out.print("Before Fold : "); l.display(); l.fold();
		 * System.out.print("After Fold : "); l.display();
		 */ // l.addLast(60);
			// System.out.print("After AddLast : ");
			// l.display();
		/*
		 * l.unfold(); System.out.print("After Unfold : "); l.display();
		 */ // l.addFirst(10);
		// l.addAt(30, 2);
		// l.addAt(40, 3);
		// l.display();
		// Removing Functions
		// l.removeAt(3);
		// l.removeFirst();
		// l.display();
		// Reverse Data Iteratively
		// l.reverseDI();
		// l.display();
		// Reverse Pointer Iteratively
		// l.reversePI();
		// l.display();
		// Display Reverse
		// l.displayReverse();
		// l.display();
		// l.reversePR();
		// l.display();
		// l.reverseDR();
		// l.display();
		// System.out.println(l.isPalindrome());
		// System.out.println(l.getMidNodeData());
		// l.display();
		l.display();
		l.removeDuplicates(); // Executing remove duplicates function
		l.display();
		// l.oddEven();
		// l.addLast(1);
		// l.display();
		// l.kReverse(2);
		// l.display();
		// l.deleteGreaterNodesRight();
		// l.display();
		// l.rearrange();
		// l.display();
		// l.head.next.next.next.next.next = l.head.next.next;
		// l.removeLoop();
		// l.display();
		/*
		 * System.out.println(l.midNodeData()); System.out.println(l.kthFromLast(4));
		 */
		// System.out.println(ll1.add(ll2));
		LinkedList ll3 = new LinkedList();

		LinkedList llA = new LinkedList();
		LinkedList llB = new LinkedList();
		llA.addLast(10);
		llA.addLast(20);
		llA.addLast(30);
		llA.addLast(40);
		llA.addLast(50);
		llB.addLast(5);
		llB.addLast(7);
		llB.addLast(15);
		llB.addLast(21);
		llB.addLast(24);

		/*
		 * ll3.merge2SortedLinkedLists(llA, llB); ll3.display(); ll3.fold();
		 * ll3.display();
		 */
		// LinkedList ll4 = ll3.mergeSort();
		// ll4.display(); // Changes done in ll4 for sorting
		// ll3.display(); // No changes done in ll3

		// Adding 2 LL
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		ll1.addLast(9);
		ll1.addLast(7);
		ll1.addLast(3);
		ll2.addLast(4);
		ll2.addLast(9);
		ll2.addLast(7);
		ll2.addLast(6);
		ll2.addLast(2);

		/*
		 * LinkedList add = ll1.add(ll2); add.display();
		 */
		// Multiply 2 LL
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		l1.addLast(2);
		l1.addLast(3);
		l1.addLast(5);
		l1.addLast(9);
		l1.addLast(9);
		l2.addLast(4);
		l2.addLast(5);

		/*
		 * LinkedList multiply = l1.add(l2); multiply.display();
		 */

		System.out.println(l.maxPalindrome());
	}
}

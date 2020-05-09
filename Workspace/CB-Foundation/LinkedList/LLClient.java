package LinkedList;

public class LLClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList linkedList = new LinkedList();
		/*
		 * linkedList.addFirst(30); linkedList.addFirst(40); linkedList.addFirst(50);
		 * linkedList.addLast(10); linkedList.addLast(20); linkedList.addAt(15, 1);
		 * linkedList.removeFirst(); linkedList.removeLast(); linkedList.removeAt(1);
		 */
		// linkedList.reverseDI();
		for (int i = 0; i <= 4; i++) {
			linkedList.addAt(i + 1, i);
		}
		// linkedList.head.next.next.next = linkedList.head.next.next;
		// linkedList.display();
		// linkedList.reverseDR2();
		// linkedList.reversePI();
		// System.out.println(linkedList.getNodeAt(2));
		// linkedList.display();
		linkedList.display();
		linkedList.floydCycle();
		linkedList.mergeSortLL();
		linkedList.display();
	}

}

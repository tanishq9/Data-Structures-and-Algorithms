package LinkedList;

public class LLClient {

	public static void main(String[] args) throws Exception {
		LinkedList list = new LinkedList();
		list.addAt(20, 0);
		list.addAt(10, 1);
		list.addAt(50, 2);
		list.addAt(40, 3);
		list.addAt(30, 4);
		list.display();
		// System.out.println(list.IsPalindromeUsingStack());
		// System.out.println(list.isPalindromeRecursively());
		// list.reverseListPR();
		list.mergeSort();
		list.display();
	}

}

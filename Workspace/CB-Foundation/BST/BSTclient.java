package BST;

public class BSTclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = { 7, 2, 1, 3 };
		BST bst = new BST(arr);
		/*
		 * bst.display(); System.out.println(bst.find(2));
		 * System.out.println(bst.max()); bst.add(9); bst.display();
		 */
		System.out.println(bst.kthSmallest(3));
	}

}

package BST;

public class MORRIS_INORDER {
	class Node {
		int data;
		Node left;
		Node right;
	}

	static Node root;

	static Node fun(Node node) {
		Node lkram = node.left;
		while (lkram.right != null && lkram.right != node) {
			lkram = lkram.right;
		}
		return lkram;
	}

	// CHAAAPA , CLIMB UP aur RIGHT CHALEGAYE
	// L Node R : In Order
	public static void main(String[] args) {
		Node node = root;
		while (node != null) {
			if (node.left != null) {
				Node lkram = fun(node);
				if (lkram.right == null) {
					// setting it for the first time
					lkram.right = node;
					node = node.left;
				} else if (lkram.right == node) {
					// it means we are again visiting the leftmost node
					System.out.println(node.data);
					lkram.right = null;
					node = node.right;
				}
			} else {
				System.out.println(node.data);
				node = node.right;
			}
		}
	}
}

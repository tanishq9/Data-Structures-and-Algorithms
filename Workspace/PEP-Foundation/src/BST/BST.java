package BST;

import java.util.LinkedList;

public class BST {

	class Node {
		int data;
		Node left;
		Node right;

		Node(int id) {
			this.data = id;
		}
	}

	public Node construct(int[] arr, int low, int high) {
		if (low > high) {
			return null;
		}
		if (low == high) {
			return new Node(arr[low]);
		}
		int mid = (low + high) / 2;
		Node newNode = new Node(arr[mid]);
		newNode.left = construct(arr, low, mid - 1);
		newNode.right = construct(arr, mid + 1, high);
		return newNode;
	}

	public void display(Node root) {
		if (root == null) {
			return;
		}
		display(root.left);
		System.out.println(root.data);
		display(root.right);
	}

	public int max(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int val = Integer.MIN_VALUE;
		if (root != null) {
			val = Math.max(max(root.right), root.data);
		}
		return val;
	}

	public int min(Node root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int val = Integer.MAX_VALUE;
		if (root != null) {
			val = Math.min(min(root.left), root.data);
		}
		return val;
	}

	public boolean find(Node root, int data) {
		if (root == null) {
			return false;
		}
		if (root.data == data) {
			return true;
		}
		boolean left = false, right = false;
		if (root.data > data) {
			left = find(root.left, data);
		} else {
			right = find(root.right, data);
		}
		return left || right;
	}

	public void printInRange(Node root, int low, int high) {
		if (root == null) {
			return;
		}
		if (low <= root.data && root.data <= high) {
			System.out.println(root.data);
			printInRange(root.left, low, high);
			printInRange(root.right, low, high);
		} else if (root.data < low) {
			printInRange(root.right, low, high);
		} else if (root.data > high) {
			printInRange(root.left, low, high);
		}
	}

	static int sum = 0;

	public void replaceWithSumLargerNodes(Node root) {
		if (root == null) {
			return;
		}
		replaceWithSumLargerNodes(root.right);
		int temp = root.data;
		root.data = sum;
		sum += temp;
		replaceWithSumLargerNodes(root.left);
	}

	public int lca(Node root, int d1, int d2) {
		Node lca = lcaHelper(root, d1, d2);
		if (lca != null) {
			return lca.data;
		} else {
			return -1;
		}
	}

	public Node lcaHelper(Node root, int d1, int d2) {
		if (root == null) {
			return null;
		}
		if (root.data == d1 || root.data == d2) {
			return root;
		}
		Node left = lcaHelper(root.left, d1, d2);
		Node right = lcaHelper(root.right, d1, d2);
		if (left != null && right != null) {
			return root;
		} else if (left == null && right != null) {
			return right;
		} else if (left != null && right == null) {
			return left;
		} else {
			return null;
		}
	}

	// O(n) time and O(h) space
	public void pairSum2(Node root, int target) {
		LinkedList<Integer> stack1 = new LinkedList();
		stack1.addFirst(min(root));
		Node current = root;
		while (!stack1.isEmpty()) {
			while (current != null) {
				stack1.addFirst(root.left.data);
				current = current.left;
			}
			if (current == null) {
				stack1.removeFirst();
				System.out.println();
			}
		}
	}

	static Node r = null;

	// O(n*Log(n)) time and constant space
	public void pairSum1(Node root, int target) {
		if (root == null) {
			return;
		}
		int comp = target - root.data;
		if (root.data < comp) {
			if (find(r, comp)) {
				System.out.println(root.data + " " + comp);
			}
		}
		pairSum1(root.left, target);
		pairSum1(root.right, target);
	}

	// Adding Node in BST
	public Node add(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		if (root.data > data) {
			Node l = add(root.left, data);
			root.left = l;
		} else if (root.data < data) {
			Node r = add(root.right, data);
			root.right = r;
		}
		return root;
	}

	// Deleting Node in BST
	public Node remove(Node root, int data) {
		if (root == null) {
			return null;
		}
		if (root.data > data) {
			Node l = remove(root.left, data);
			root.left = l;
		} else if (root.data < data) {
			Node r = remove(root.right, data);
			root.right = r;
		} else if (root.data == data) {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left != null && root.right == null) {
				return root.left;
			} else if (root.left == null && root.right != null) {
				return root.right;
			} else if (root.left != null && root.right != null) {
				int lmax = max(root);
				root.data = lmax;
				root.left = remove(root.left, lmax);
				/*
				 * Node lmaxToBeRemoved = remove(root, lmax); if (lmaxToBeRemoved.left == null
				 * && lmaxToBeRemoved.right == null) { return null; } else * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node * Node if
				 * (lmaxToBeRemoved.left != null && lmaxToBeRemoved.right == null) { return
				 * lmaxToBeRemoved.left; } else if (lmaxToBeRemoved.left == null &&
				 * lmaxToBeRemoved.right != null) { return lmaxToBeRemoved.right; }
				 */
				return root;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		int[] sortedArr = { 10, 20, 30, 50, 60, 70, 80 };
		BST bst = new BST();
		Node root = bst.construct(sortedArr, 0, sortedArr.length - 1);
		r = root;
		bst.display(root);
		/*
		 * System.out.println(); System.out.println(bst.find(root, 40));
		 * System.out.println(); System.out.println(bst.max(root));
		 * System.out.println(bst.min(root)); System.out.println();
		 * bst.printInRange(root, 50, 100);
		 */
		// sum = 0;
		// bst.replaceWithSumLargerNodes(root);
		// bst.display(root);
		// System.out.println();
		/*
		 * System.out.println(bst.lca(root, 20, 30)); System.out.println();
		 * bst.pairSum1(root, 100);
		 * 
		 */ System.out.println();
		bst.add(root, 40);
		bst.display(root);
		bst.remove(root, 40);
		System.out.println();
		bst.display(root);
		bst.printInRange(root, 50, 100);
	}

}

package BST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.tree.TreeNode;

public class BST {
	private class Node {
		Node left;
		Node right;
		int data;

		Node(int d, Node l, Node r) {
			this.data = d;
			this.right = r;
			this.left = l;
		}
	}

	private Node root = null;
	private int size;

	BST(Integer[] sortedArray) {
		this.size = 0;
		Arrays.sort(sortedArray);
		this.root = this.constructTree(sortedArray, 0, sortedArray.length - 1);
	}

	private Node constructTree(Integer[] sortedArray, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		Node node = new Node(sortedArray[mid], null, null);
		this.size++;
		node.left = constructTree(sortedArray, low, mid - 1);
		node.right = constructTree(sortedArray, mid + 1, high);
		return node;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + "=>");
		} else {
			System.out.print("END=>");
		}
		System.out.print(node.data);
		if (node.right != null) {
			System.out.println("<=" + node.right.data);
		} else {
			System.out.println("<=END");
		}
		if (node.left != null) {
			this.display(node.left);
		}
		if (node.right != null) {
			this.display(node.right);
		}
	}

	public boolean find(int data) {
		return find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (data == node.data) {
			return true;
		}
		if (data > node.data) {
			return find(node.right, data);
		}
		if (data < node.data) {
			return find(node.left, data);
		}
		return false;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		if (node.right != null) {
			return max(node.right);
		}
		return node.data;
	}

	public void add(int data) {
		add(this.root, data);
	}

	private void add(Node node, int data) {
		if (node.data > data) {
			if (node.left != null) {
				add(node.left, data);
			} else {
				node.left = new Node(data, null, null);
				this.size++;
			}
		} else if (node.data < data) {
			if (node.right != null) {
				add(node.right, data);
			} else {
				node.right = new Node(data, null, null);
				this.size++;
			}
		} else {

		}
	}

	public void remove(int data) {
		remove(this.root, null, false, data);
	}

	private void remove(Node node, Node parent, boolean islc, int data) {

		// node null hogayi hai implying jo node humme chahiye voh yha hai hi nhi
		if (node == null) {
			return;
		}
		if (node.data < data) {
			remove(node.right, node, false, data);
		} else if (node.data > data) {
			remove(node.left, node, true, data);
		} else {
			// the node to be removed is a leaf node
			if (node.left == null && node.right == null) {
				if (islc) {
					node.left = null;
				} else {
					node.right = null;
				}
			}
			// if only left child is null
			if (node.left == null && node.right != null) {
				if (islc) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			}
			// if only the right child is null
			if (node.left != null && node.right == null) {
				if (islc) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			}
			// if both the child are not null
			else {
				int max = max(node.left);
				node.data = max;
				// this remove function will always ensure that the max_node.right is null
				remove(node.left, node, true, max);

			}
		}
	}

	public void ct(int[] st) {
		this.root = ct(st, 0, st.length - 1);
	}

	private Node ct(int[] st, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = (low + high) / 2;
		Node node = new Node(st[mid], null, null);
		node.left = ct(st, low, mid - 1);
		node.right = ct(st, mid + 1, high);
		return node;
	}

	public void delete(int item) {
		delete(this.root, null, false, item);
	}

	private void delete(Node node, Node parent, boolean islc, int item) {
		if (node.data < item) {
			delete(node.right, parent, true, item);
		} else if (node.data > item) {
			delete(node.left, parent, false, item);
		} else {
			// none of the child exist
			if (node.left == null && node.right == null) {
				if (islc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
			// either of the child is not null
			if (node.left != null && node.right == null) {
				if (islc) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			} else if (node.left == null && node.right != null) {
				if (islc) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			}
			// if both the child are not null
			int lmax = max(node);
			node.data = lmax;
			delete(node.left, node, true, lmax);
		}
	}

	class Mycmp implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return 0;
		}

	}

	private static ArrayList<Integer> list = new ArrayList<>();

	public int kthsmallest(Node A, int B) {
		inOrder(A);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		return list.get(B - 1);
	}

	public int kthSmallest(int B) {
		return kthsmallest(this.root, B);
	}

	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		list.add(node.data);
		inOrder(node.right);
	}

}

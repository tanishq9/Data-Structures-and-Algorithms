package AVL;

public class AVL {

	class Node {
		int data;
		Node left;
		Node right;
		int ht;
		int bl;

		Node(int id) {
			this.data = id;
			this.ht = 1;
			this.bl = 0;
			this.left = null;
			this.right = null;
		}
	}

	public void sethb(Node root) {
		int lh = root.left == null ? 0 : root.left.ht;
		int rh = root.right == null ? 0 : root.right.ht;
		root.ht = Math.max(lh, lh) + 1;
		root.bl = lh - rh;
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
		sethb(newNode);
		return newNode;
	}

	public void display(Node root) {
		if (root == null) {
			return;
		}
		display(root.left);
		System.out.println(root.data + "[" + root.ht + "," + root.bl + "]");
		display(root.right);
	}

	public void dis(Node root) {
		if (root == null) {
			return;
		} else if (root.left != null && root.right != null) {
			System.out.print(root.left.data + "->");
			System.out.print(root.data + "[" + root.ht + "," + root.bl + "]");
			System.out.println("<-" + root.right.data);
			dis(root.left);
			dis(root.right);
		} else if (root.left != null && root.right == null) {
			System.out.print(root.left.data + "->");
			System.out.print(root.data + "[" + root.ht + "," + root.bl + "]");
			System.out.println("<-.");
			dis(root.left);
		} else if (root.left == null && root.right != null) {
			System.out.print(".->");
			System.out.print(root.data + "[" + root.ht + "," + root.bl + "]");
			System.out.println("<-" + root.right.data);
			dis(root.right);
		} else if (root.left == null && root.right == null) {
			System.out.print(".->");
			System.out.print(root.data + "[" + root.ht + "," + root.bl + "]");
			System.out.println("<-.");
		}
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

	// Adding Node in AVL
	public Node add(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		if (root.data > data) {
			root.left = add(root.left, data);
		} else if (root.data < data) {
			root.right = add(root.right, data);
		}
		sethb(root);
		root = handleImbalance(root);
		return root;
	}

	public Node handleImbalance(Node root) {
		if (root.bl == 2 && root.left.bl > 0) {
			// ll
			root = rightRotate(root);
		} else if (root.bl == 2 && root.left.bl <= 0) {
			// lr
			root.left = leftRotate(root.left);
			root = rightRotate(root);
		} else if (root.bl == -2 && root.right.bl < 0) {
			// rr
			root = leftRotate(root);
		} else if (root.bl == -2 && root.right.bl >= 0) {
			// rl
			root.right = rightRotate(root.right);
			root = leftRotate(root);
		}
		return root;
	}

	private Node rightRotate(Node z) {
		Node y = z.left;
		Node t = y.right;
		y.right = z;
		z.left = t;
		sethb(z);
		sethb(y);
		return y;
	}

	private Node leftRotate(Node z) {
		Node y = z.right;
		Node t = y.left;
		y.left = z;
		z.right = t;
		sethb(z);
		sethb(y);
		return y;
	}

	// Deleting Node in AVL
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
				return root;
			}
		}
		if (root != null) {
			sethb(root);
			handleImbalance(root);
		}
		return root;
	}

	public static void main(String[] args) {
		int[] sortedArr = { 12, 25, 37, 50, 62, 75, 87 };
		AVL avl = new AVL();
		Node root = avl.construct(sortedArr, 0, sortedArr.length - 1);
		avl.display(root);
		System.out.println();
		avl.dis(root);
		avl.add(root, 5);
		avl.add(root, 10);
		System.out.println();
		avl.dis(root);
		avl.add(root, 15);
		System.out.println();
		avl.dis(root);
		avl.remove(root, 5);
		avl.remove(root, 10);
		System.out.println();
		avl.dis(root);
	}

}

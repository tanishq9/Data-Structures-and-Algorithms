package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

	private class Node {
		Node left;
		Node right;
		int data;

		Node(int d, Node l, Node r) {
			data = d;
			left = l;
			right = r;
		}
	}

	private int size;
	private Node root;

	BinaryTree() {
		this.size = 0;
		Scanner scanner = new Scanner(System.in);
		this.root = takeInput(scanner, null, false);
	}

	private Node takeInput(Scanner scanner, Node parent, boolean isleftorright) {
		if (parent == null) {
			System.out.println("Enter data for root node");
		} else {
			if (isleftorright) {
				System.out.println("Enter the data for the left node");
			} else {
				System.out.println("Enter the data for the right node");
			}
		}
		int nodeData = scanner.nextInt();
		Node node = new Node(nodeData, null, null);
		this.size++;
		boolean choice = false;
		System.out.println("Do You have left child for " + node.data);
		choice = scanner.nextBoolean();
		if (choice) {
			node.left = takeInput(scanner, parent, true);
		}
		choice = false;
		System.out.println("Do You have right child for " + node.data);
		choice = scanner.nextBoolean();
		if (choice) {
			node.right = this.takeInput(scanner, node, false);
		}
		return node;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + "=>");
		} else {
			System.out.print("End");
		}
		System.out.println(node);
		if (node.right != null) {
			System.out.print(node.right);
		} else {
			System.out.print("End");
		}
		if (node.left != null) {
			display(node.left);
		}
		if (node.right != null) {
			display(node.right);
		}
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		int l = height(root.left);
		int r = height(root.right);
		return Math.max(l, r) + 1;
	}

	public int minDepthRecur() {
		return minDepthRecur(this.root);
	}

	private int minDepthRecur(Node A) {
		if (A == null) {
			return 0;
		}
		if (A.left == null && A.right == null) {
			return 1;
		}
		if (A.left == null) {
			return minDepthRecur(A.right) + 1;
		}
		if (A.right == null) {
			return minDepthRecur(A.left) + 1;
		}
		return Math.min(minDepthRecur(A.left), minDepthRecur(A.right)) + 1;
	}

	public int hasPathSum(Node A, int B) {
		int currentSum = 0;
		return hasPathSum(A, B, currentSum);
	}

	class Pair {
		Node node;
		int level;

		Pair(Node n, int lvl) {
			this.node = n;
			this.level = lvl;
		}
	}

	public int minDepthIter() {
		return minDepthIter(this.root);
	}

	private int minDepthIter(Node root) {
		LinkedList<Pair> list = new LinkedList<>();
		list.push(new Pair(root, 0));
		int level = 0;
		while (!list.isEmpty()) {
			level++;
			Pair pair = list.pop();
			if (pair.node.left == null && pair.node.right == null) {
				return pair.level;
			}
			if (pair.node.left != null) {
				list.add(new Pair(pair.node.left, pair.level + 1));
			} else if (pair.node.right != null) {
				list.add(new Pair(pair.node.right, pair.level + 1));
			}
		}
		return -1;
	}

	private int hasPathSum(Node A, int B, int cs) {
		// If node is not a leaf node
		if (A == null) {
			return 0;
		}
		// If it is a leaf node , eg empty tree
		if (A.left == null && A.right == null) {
			// If the path sum is matched
			if (cs + A.data == B) {
				return 1;
			} else {
				return 0;
			}
		}
		int left = hasPathSum(A.left, B, cs + A.data);
		int right = hasPathSum(A.right, B, cs + A.data);
		if (left == 1 || right == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	private ArrayList<ArrayList<Integer>> result = null;

	public ArrayList<ArrayList<Integer>> pathSum(int B) {
		return pathSum(this.root, B);
	}

	public ArrayList<ArrayList<Integer>> pathSum(Node A, int B) {
		this.result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		pathSumHelper(A, B, list);
		return result;
	}

	private void pathSumHelper(Node A, int B, ArrayList<Integer> list) {
		// Empty List Base case
		if (A == null) {
			return;
		}
		// If that's a root node then consider if the sum matches
		if (A.left == null && A.right == null) {
			if (B == A.data) {
				list.add(A.data);
				this.result.add((ArrayList<Integer>) list.clone());
				list.remove(list.size() - 1);
			}
			return;
		}
		list.add(A.data);
		pathSumHelper(A.left, B - A.data, list);
		pathSumHelper(A.right, B - A.data, list);
		// When both the left and right path of the tree have been explored then I would
		// remove that node
		list.remove(list.remove(list.size() - 1));
	}

	long sum = 0;

	public int sumNumbers() {
		return sumNumbers(this.root);
	}

	public int sumNumbers(Node A) {
		sum = 0;
		String str = "";
		sumNumbersHelper(A, str);
		return (int) (sum % 1003);
	}

	private void sumNumbersHelper(Node A, String str) {
		if (A == null) {
			return;
		}
		if (A.left == null && A.right == null) {
			str = str + String.valueOf(A.data);
			sum += Long.valueOf(str);
			return;
		}
		sumNumbersHelper(A.left, str + String.valueOf(A.data));
		sumNumbersHelper(A.right, str + String.valueOf(A.data));
	}

	public int LCA(int o, int t) {
		return LCA(this.root, o, t).data;
	}

	private Node LCA(Node root, int o, int t) {
		if (root == null) {
			return null;
		}
		if (root.data == o || root.data == t) {
			return root;
		}
		Node left = LCA(root.left, o, t);
		Node right = LCA(root.right, o, t);
		if (left != null && right != null) {
			return root;
		}
		if (left != null && right == null) {
			return right;
		}
		if (left == null && right != null) {
			return left;
		} else {
			return null;
		}
	}

	public void zz() {
		Node node = this.root;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(node);
		while (!s1.empty() || !s2.empty()) {
			while (!s1.empty()) {
				Node popped = s1.pop();
				if (popped.left != null) {
					s2.push(popped.left);
				}
				if (popped.right != null) {
					s2.push(popped.right);
				}
			}
			while (!s2.empty()) {
				Node popped = s2.pop();
				if (popped.right != null) {
					s1.push(popped.right);
				}
				if (popped.left != null) {
					s1.push(popped.left);
				}
			}
		}
	}

}

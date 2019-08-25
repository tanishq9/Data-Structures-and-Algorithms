package BinaryTree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTree {
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

	private int size;
	private Node root;
	HashMap<Integer, Integer> hashmap = new HashMap<>();

	BinaryTree() {
		Scanner scanner = new Scanner(System.in);
		this.root = takeInput(scanner, null, false);
	}

	private Node takeInput(Scanner s, Node parent, boolean isleftorright) {
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			if (isleftorright) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		int nodeData = s.nextInt();
		Node node = new Node(nodeData, null, null);
		this.size++;

		boolean choice = false;
		System.out.println("Do You have left child for " + node.data);
		choice = s.nextBoolean();
		if (choice) {
			node.left = this.takeInput(s, node, true);
		}

		choice = false;
		System.out.println("Do You have right child for " + node.data);
		choice = s.nextBoolean();
		if (choice) {
			node.right = this.takeInput(s, node, false);
		}

		return node;
	}

	public void display() {
		this.display(this.root);
	}

	public void display(Node node) {
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
			display(node.left);
		}
		if (node.right != null) {
			display(node.right);
		}
	}

	// Height of the tree
	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return 0;
		}
		int lcontri = height(node.left);
		int rcontri = height(node.right);
		return Math.max(lcontri, rcontri) + 1;
	}

	// Size of the tree
	public int numNodes() {
		return numNodes(this.root);
	}

	private int numNodes(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int lcontri = numNodes(node.left);
		int rcontri = numNodes(node.right);
		return lcontri + rcontri + 1;
	}

	// Max element in tree
	public int maxElement() {
		return maxElement(this.root);
	}

	private int maxElement(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		if (node.left == null && node.right == null) {
			return node.data;
		}
		int lcontri = maxElement(node.left);
		int rcontri = maxElement(node.right);
		return Math.max(Math.max(lcontri, rcontri), node.data);
	}

	public boolean find(int data) {
		return find(data, this.root);
	}

	private boolean find(int data, Node node) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		}
		boolean left = find(data, node.left);
		boolean right = find(data, node.right);
		if (left == true || right == true) {
			return true;
		}
		return false;
	}

	public void preOrder() {
		preOrder(this.root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder() {
		postOrder(this.root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	public void inOrder() {
		inOrder(this.root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public void levelOrder() {
		levelOrder(this.root);
	}

	private void levelOrder(Node node) {
		LinkedList<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		queue.add(node);
		// stack.push(node);
		while (!queue.isEmpty()) {
			node = queue.removeFirst();
			// node = stack.pop();
			System.out.print(node.data + " ");
			if (node.left != null) {
				queue.addLast(node.left);
				// stack.push(node.left);
			}
			if (node.right != null) {
				// stack.push(node.right);
				queue.addLast(node.right);
			}
		}
	}

	public int lca(int e1, int e2) {
		return lca(this.root, e1, e2).data;
	}

	private Node lca(Node node, int e1, int e2) {
		if (node == null) {
			return null;
		}
		if (node.data == e1 || node.data == e2) {
			return node;
		}
		Node llca = this.lca(node.left, e1, e2);
		Node rlca = this.lca(node.right, e1, e2);
		// After both the left and right subtrees have been processed
		if (llca != null && rlca != null) {
			return node;
		} else if (llca != null) {
			return llca;
		} else if (rlca != null) {
			return rlca;
		} else {
			return null;
		}

	}

	public void mirrorTree() {
		mirrorTree(this.root);
	}

	private void mirrorTree(Node node) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			return;
		}
		mirrorTree(node.left);
		mirrorTree(node.right);
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	int count = 0;

	public void dist(int k) {
		dist(this.root, k, 0);
		System.out.println("                  " + count);
	}

	private void dist(Node node, int k, int curr) {
		if (node == null) {
			return;
		}
		if (curr == k) {
			System.out.print(node.data + " ");
			count++;
			return;
		}
		dist(node.left, k, curr + 1);
		dist(node.right, k, curr + 1);
	}

	public Boolean isPresent2(int data) {
		return isPresent2(this.root, data);
	}

	private Boolean isPresent2(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		}
		Boolean left = isPresent2(node.left, data);
		Boolean right = isPresent2(node.right, data);
		if (left || right) {
			return true;
		}
		return false;
	}

	public int distFromRoot(int data) {
		return distFromRoot(this.root, data, 0);
	}

	private int distFromRoot(Node node, int data, int level) {
		if (node == null) {
			return -1;
		}
		if (node.data == data) {
			return level;
		}
		int leftcontri = distFromRoot(node.left, data, level + 1);
		int rightcontri = distFromRoot(node.right, data, level + 1);
		if (leftcontri != -1 && rightcontri == -1) {
			return leftcontri;
		} else if (leftcontri == -1 && rightcontri != -1) {
			return rightcontri;
		}
		return -1;
	}

	public int lca2(int val1, int val2) {
		return lca2(this.root, val1, val2).data;
	}

	private Node lca2(Node node, int val1, int val2) {
		if (node == null) {
			return null;
		}
		if (node.data == val1 || node.data == val2) {
			return node;
		}
		Node left = lca2(node.left, val1, val2);
		Node right = lca2(node.right, val1, val2);
		if (left != null && right != null) {
			return node;
		} else if (left == null && right != null) {
			return right;
		} else if (right == null && left != null) {
			return left;
		} else {
			return null;
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}
	/*--------------------------------CN BINARY TREE QUESTIONS--------------------------------------*/

	public int LCAof2nodes(int d1, int d2) {
		return LCAof2nodes(this.root, d1, d2).data;
	}

	public Node LCAof2nodes(Node node, int d1, int d2) {
		if (node == null) {
			return null;
		}
		if (node.data == d1 || node.data == d2) {
			return node;
		}
		Node l = LCAof2nodes(node.left, d1, d2);
		Node r = LCAof2nodes(node.right, d1, d2);
		if (l != null && r != null) {
			return node;
		} else if (l != null && r == null) {
			return l;
		} else if (l == null && r != null) {
			return r;
		} else {
			return null;
		}
	}

	class solution {
		int val = 0;
	}

	public int KthLevelSum(int k) {
		solution obj = new solution();
		KthLevelSum(this.root, k, obj);
		return obj.val;
	}

	private void KthLevelSum(Node node, int k, solution obj) {
		if (node == null || k < 0) {
			return;
		}
		if (k == 0) {
			obj.val += node.data;
			return;
		}
		KthLevelSum(node.left, k - 1, obj);
		KthLevelSum(node.right, k - 1, obj);
	}

	public int leftSum() {
		solution obj = new solution();
		leftSum(this.root, obj);
		return obj.val;
	}

	public int leftSum(Node node, solution obj) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return node.data;
		}
		int l = leftSum(node.left, obj);
		int r = leftSum(node.right, obj);
		obj.val += l;
		// System.out.println(l);
		return node.data;
	}

	public int levelNode(int data) {
		solution obj = new solution();
		obj.val = 1;
		levelNode(this.root, data, 1, obj);
		return obj.val;
	}

	private Boolean levelNode(Node node, int data, int level, solution obj) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		}
		Boolean left = levelNode(node.left, data, level + 1, obj);
		Boolean right = levelNode(node.right, data, level + 1, obj);
		if (left || right) {
			obj.val = level + 1;
			return false;
		}
		return false;
	}

	static class myComparator implements Comparator<String> {
		public int compare(String one, String two) {
			String XY = one + two;
			String YX = two + one;
			if (XY.compareTo(YX) > 0) {
				return -1;
			}
			return 1;
		}
	}

	public void printLargest() {
		ArrayList<String> list = new ArrayList<>();
		printLargest(this.root, list);
		list.sort(new myComparator());
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
		}
		System.out.println(sb.toString());
	}

	private void printLargest(Node node, ArrayList<String> list) {
		if (node == null) {
			return;
		}
		list.add(String.valueOf(node.data));
		printLargest(node.left, list);
		printLargest(node.right, list);
	}

	public void depthTree() {
		depthTree(this.root, 0);
		inOrder();
	}

	private void depthTree(Node node, int level) {
		if (node == null) {
			return;
		}
		depthTree(node.left, level + 1);
		depthTree(node.right, level + 1);
		node.data = level;
	}

	static class myComparatorBasic implements Comparator<Integer> {
		public int compare(Integer one, Integer two) {
			if (one > two) {
				return 1;
			} else if (one < two) {
				return -1;
			}
			return 0;
		}
	}

	public String tripleSum(int num) {
		ArrayList<Integer> list = new ArrayList<>();
		tripleSum(this.root, list);
		list.sort(new myComparatorBasic());
		for (int i = 0; i < list.size(); i++) {
			int l = i + 1;
			int r = list.size() - 1;
			while (l < r) {
				if (list.get(i) + l + r < num) {
					l++;
				} else if (list.get(i) + l + r > num) {
					r--;
				} else {
					return "Yes";
				}
			}
		}
		return "No";
	}

	private void tripleSum(Node node, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}
		list.add(node.data);
		tripleSum(node.left, list);
		tripleSum(node.right, list);
	}

	public void convertToMirror() {
		convertToMirror(this.root);
	}

	private void convertToMirror(Node node) {
		if (node == null) {
			return;
		}
		convertToMirror(node.left);
		convertToMirror(node.right);
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	public Boolean checkIfTreesAreMirror(Node node1, Node node2) {
		// node1 and node2 are the root nodes of 2 trees
		if (node1 == null && node2 == null) {
			return true;
		}
		// If only one of them is empty
		if (node1 == null || node2 == null) {
			return false;
		}
		return node1.data == node2.data && checkIfTreesAreMirror(node1.left, node2.left)
				&& checkIfTreesAreMirror(node1.right, node2.right);
	}

	public Boolean isoMorphic(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.data != root2.data) {
			return false;
		}
		return (isoMorphic(root1.left, root2.left) && isoMorphic(root1.right, root2.right))
				|| (isoMorphic(root1.left, root2.right) && isoMorphic(root1.right, root2.left));
	}

	int maxLevel = 0;

	public void leftView() {
		leftView(this.root, 1);
	}

	private void leftView(Node node, int level) {
		if (node == null) {
			return;
		}
		if (level > maxLevel) {
			System.out.println(node.data);
			maxLevel = level;
		}
		leftView(node.left, level + 1);
		leftView(node.right, level + 1);
	}

	public void topView() {
		topView(this.root);
	}

	static class Pair {
		int hd;
		Node node;

		Pair(Node in, int d) {
			node = in;
			hd = d;
		}
	}

	static class Data {
		int index;
		int data;

		Data(int i, int d) {
			index = i;
			data = d;
		}
	}

	static class myComparator2 implements Comparator<Data> {
		public int compare(Data one, Data two) {
			if (one.index < two.index) {
				return -1;
			} else if (one.index > two.index) {
				return 1;
			}
			return 0;
		}
	}

	private void topView(Node node) {
		if (node == null) {
			return;
		}
		HashSet<Integer> set = new HashSet<>();
		Queue<Pair> queue = new LinkedList<>();
		ArrayList<Data> list = new ArrayList<>();
		queue.add(new Pair(this.root, 0));
		while (!queue.isEmpty()) {
			Pair popped = queue.poll();
			int hd = popped.hd;
			Node n = popped.node;
			if (!set.contains(hd)) {
				set.add(hd);
				// System.out.println(n.data);
				list.add(new Data(hd, n.data));
			}
			if (n.left != null) {
				queue.add(new Pair(n.left, hd - 1));
			}
			if (n.right != null) {
				queue.add(new Pair(n.right, hd + 1));
			}
		}
		list.sort(new myComparator2());
		for (Data d : list) {
			System.out.print(d.data + " ");
		}
	}

	static Boolean is = true;

	public Boolean isHeightBalanced() {
		isHeightBalanced(this.root);
		if (is == false) {
			return false;
		}
		return true;
	}

	public int isHeightBalanced(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int l = isHeightBalanced(node.left);
		int r = isHeightBalanced(node.right);
		if (Math.abs(l - r) >= 1) {
			is = false;
		}
		return Math.max(l, r) + 1;
	}

	// A simple function to print leaf nodes of a binary tree
	private void printLeaves(Node node) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			System.out.print(node.data + " ");
			return;
		}
		printLeaves(node.left);
		printLeaves(node.right);
	}

	public void printLeaves() {
		printLeaves(this.root);
	}

	// To print only the left boundary and not the leave nodes
	public void printLeft() {
		printLeft(this.root.left);
	}

	private void printLeft(Node node) {
		if (node == null) {
			return;
		}
		if (node.left != null) { // ensuring the current code is not a leaf node
			System.out.print(node.data + " ");
			printLeft(node.left);
		} else if (node.right != null) { // ensuring the current code is not a leaf node
			System.out.print(node.data + " ");
			printLeft(node.right);
		}
	}

	public void printRight() {
		printRight(this.root.right);
	}

	private void printRight(Node node) {
		if (node == null) {
			return;
		}
		if (node.right != null) {
			printRight(node.right);
			System.out.print(node.data + " ");
		} else if (node.left != null) {
			printRight(node.left);
			System.out.print(node.data + " ");
		}
	}

	public void boundaryView() {
		System.out.print(root.data + " ");
		printLeft();
		printLeaves();
		printRight();
	}

	class MaxLevel {
		int max = 0;
	}

	public int deepestLeft() {
		MaxLevel maxLevel = new MaxLevel();
		deepestLeft(this.root, 0, maxLevel, true);
		return maxLevel.max;
	}

	private void deepestLeft(Node node, int level, MaxLevel maxLevel, Boolean isLeft) {
		if (node == null) {
			return;
		}
		if (isLeft == true && level > maxLevel.max) {
			maxLevel.max = level;
		}
		deepestLeft(node.left, level + 1, maxLevel, true);
		deepestLeft(node.right, level + 1, maxLevel, false);
	}

	static int val = 0;

	static class MaxLevel2 {
		int max = 0;
		Node res = null;
	}

	static Node deepestRightLeaf(Node node) {
		MaxLevel2 maxlevel = new MaxLevel2();
		deepest(node, 0, maxlevel, false);
		return maxlevel.res;
	}

	static void deepest(Node node, int level, MaxLevel2 maxlevel2, Boolean isRight) {
		if (node == null) {
			return;
		}
		if (isRight == true && level >= maxlevel2.max) {
			maxlevel2.max = level;
			val = node.data;
			maxlevel2.res = node;
		}
		deepest(node.left, level + 1, maxlevel2, false);
		deepest(node.right, level + 1, maxlevel2, true);
	}

	public int minDepth() {
		return minDepth(this.root);
	}

	class Item {
		Node node;
		int depth = -1;

		Item(Node in, int id) {
			node = in;
			depth = id;
		}
	}

	private int minDepth(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		Queue<Item> q = new LinkedList<>();
		q.add(new Item(root, 1));
		int curr_depth = -1;
		while (!q.isEmpty()) {
			Item item = q.poll();
			Node popped = item.node;
			curr_depth = item.depth;
			if (popped.left == null && popped.right == null) {
				return curr_depth;
			}
			if (popped.left != null) {
				item = new Item(popped.left, curr_depth + 1);
				q.add(item);
			}
			if (popped.right != null) {
				item = new Item(popped.right, curr_depth + 1);
				q.add(item);
			}
		}
		return -1;
	}

	public void invert() {
		invert(this.root);
	}

	private Node invert(Node node) {
		if (node == null) {
			return null;
		}
		Node left = invert(node.left);
		Node right = invert(node.right);
		node.left = right;
		node.right = left;
		return node;
	}

	public void zigzag(Node node) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(node);
		while (!s1.empty() || !s2.empty()) {
			while (!s1.empty()) {
				Node current = s1.pop();
				if (current.left != null) {
					s2.push(current.left);
				}
				if (current.right != null) {
					s2.push(current.right);
				}
			}
			while (!s2.empty()) {
				Node current = s2.pop();
				if (current.right != null) {
					s1.push(current.right);
				}
				if (current.left != null) {
					s1.push(current.left);
				}
			}
		}
	}

	// Constructing tree from inorder and preorder
	static int preIndex = 0;

	public void constructFromInandPre(int[] pre, int[] in) {
		construct(in, pre, 0, in.length - 1);
	}

	private Node construct(int[] in, int[] pre, int start, int end) {
		if (start > end) {
			return null;
		}
		Node node = new Node(pre[preIndex++], null, null);
		int inindex = search(in, start, end, node.data);
		node.left = construct(in, pre, start, inindex - 1);
		node.right = construct(in, pre, inindex + 1, end);
		return node;
	}

	public int search(int[] in, int start, int end, int data) {
		int i;
		for (i = start; i <= end; i++) {
			if (in[i] == data) {
				return i;
			}
		}
		return i;
	}

	// construct tree from inorder and postorder
	class PostIndex {
		int index = 0;
		ArrayList<Integer> li = new ArrayList<>();

	}

	public void constructFromInandPost(int[] post, int[] in) {
		PostIndex p = new PostIndex();
		p.index = post.length - 1;
		construct(in, post, 0, in.length - 1, p);
	}

	private Node construct(int[] in, int[] post, int start, int end, PostIndex p) {
		if (start > end) {
			return null;
		}
		Node node = new Node(post[p.index], null, null);
		p.index -= 1;
		int inindex = search(in, start, end, node.data);
		node.left = construct(in, post, start, inindex - 1, p);
		node.right = construct(in, post, inindex + 1, end, p);
		return node;
	}

}

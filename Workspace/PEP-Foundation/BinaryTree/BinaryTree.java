package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class BinaryTree {

	private class Node {
		int data;
		Node left;
		Node right;

		Node(int idata) {
			this.data = idata;
			this.left = null;
			this.right = null;
		}
	}

	public Node construct(ArrayList<Integer> dlist) {
		Node root = null;
		ArrayList<Node> nlist = new ArrayList<>();
		for (int i = 0; i < dlist.size(); i++) {
			if (dlist.get(i) == -1) {
				nlist.remove(nlist.size() - 1);
			} else {
				Node newNode = new Node(dlist.get(i));
				if (nlist.size() == 0) {
					root = newNode;
				} else {
					Node ln = nlist.get(nlist.size() - 1);
					if (ln.left == null) {
						ln.left = newNode;
					} else if (ln.right == null) {
						ln.right = newNode;
					}
				}
				nlist.add(newNode);
			}
		}
		return root;
	}

	public void display(Node root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			System.out.print(root.left.data + "->");
		} else {
			System.out.print("END->");
		}
		System.out.print(root.data);
		if (root.right != null) {
			System.out.println("<-" + root.right.data);
		} else {
			System.out.println("<-END");
		}
		display(root.left);
		display(root.right);
	}

	public int size(Node root) {
		if (root == null) {
			return 0;
		}
		int s1 = size(root.left);
		int s2 = size(root.right);
		return s1 + s2 + 1;
	}

	public int max(Node root) {
		int m1 = 0, m2 = 0;
		if (root.left != null) {
			m1 = max(root.left);
		}
		if (root.right != null) {
			m2 = max(root.right);
		}
		return Math.max(Math.max(m1, m2), root.data);
	}

	public int height(Node root) {
		if (root == null) {
			return 0;
		}
		int h1 = height(root.left);
		int h2 = height(root.right);
		return Math.max(h1, h2) + 1;
	}

	public int sum(Node root) {
		int s1 = 0, s2 = 0;
		if (root.left != null) {
			s1 = sum(root.left);
		}
		if (root.right != null) {
			s2 = sum(root.right);
		}
		return s1 + s2 + root.data;
	}

	public boolean find(Node root, int data) {
		if (root == null) {
			return false;
		}
		if (root.data == data) {
			return true;
		}
		boolean isleft = find(root.left, data);
		if (isleft) {
			return true;
		}
		boolean isright = find(root.right, data);
		if (isright) {
			return true;
		}
		return false;
	}

	static boolean isPresent = false;
	static ArrayList<Integer> distanceNodes = new ArrayList<>();

	// Ask this doubt !?
	public void getPath(Node root, int data, int k) {
		if (root == null) {
			return;
		}
		if (k == 0) {
			distanceNodes.add(root.data);
			return;
		}
		if (root.data == data) {
			isPresent = true;
		}

		if (isPresent == true) {
			getPath(root.left, data, k - 1);
			getPath(root.right, data, k - 1);
			if (root.data == data)
				isPresent = false;
		} else {
			getPath(root.left, data, k);
			getPath(root.right, data, k);
		}
	}

	public ArrayList<Integer> kDown(Node root, int k) {
		if (root == null) {
			return null;
		}
		if (k == 0) {
			ArrayList<Integer> baseResult = new ArrayList<>();
			baseResult.add(root.data);
			return baseResult;
		}
		ArrayList<Integer> isleft = kDown(root.left, k - 1);
		ArrayList<Integer> isright = kDown(root.right, k - 1);
		if (isright != null && isleft != null) {
			isright.addAll(isleft);
			return isright;
		} else if (isright != null) {
			return isright;
		} else if (isleft != null) {
			return isleft;
		}
		return null;
	}

	// K-far
	public void KDown(Node root, int k) {
		if (root == null) {
			System.out.println(root.data);
			return;
		}
		KDown(root.left, k - 1);
		KDown(root.right, k - 1);
	}

	public ArrayList<Node> rootToNode(Node root, int data) {
		if (root == null) {
			return null;
		}
		if (root.data == data) {
			ArrayList<Node> baseResult = new ArrayList<>();
			baseResult.add(root);
			return baseResult;
		}
		ArrayList<Node> isleft = rootToNode(root.left, data);
		if (isleft != null) {
			isleft.add(root);
			return isleft;
		}
		ArrayList<Node> isright = rootToNode(root.right, data);
		if (isright != null) {
			isright.add(root);
			return isright;
		}
		return null;
	}

	public void kdown(Node root, int k, Node phb) {
		if (root == null || root == phb) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
		}
		kdown(root.left, k - 1, phb);
		kdown(root.right, k - 1, phb);
	}

	public void kFar(Node root, int data, int k) {
		ArrayList<Node> rton = rootToNode(root, data);
		Node prohibitor = null;
		for (int i = 0; i < rton.size(); i++) {
			kdown(rton.get(i), k - i, prohibitor);
			prohibitor = rton.get(i);
		}
	}

	// Ask Doubt !? Cleared
	boolean removeLeaves(Node root) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		if (removeLeaves(root.left)) {
			root.left = null;
			return false;
		}
		if (removeLeaves(root.right)) {
			root.right = null;
			return false;
		}
		return false;
	}

	Node remove_Leaves(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return null;
		}
		root.left = remove_Leaves(root.left);
		root.right = remove_Leaves(root.right);
		return root;
	}

	void printSingleChild(Node root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}
		if (root.left == null && root.right != null) {
			System.out.println(root.data);
		}
		if (root.left != null && root.right == null) {
			System.out.println(root.data);
		}
		printSingleChild(root.left);
		printSingleChild(root.right);
	}

	void printRootLeadPathInRange(Node root, int lo, int hi, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			result.add(root.data);
			int sum = 0;
			for (int element : result) {
				sum += element;
			}
			if (lo <= sum && sum <= hi) {
				System.out.println(result);
			}
			result.remove(result.size() - 1);
		}
		result.add(root.data);
		printRootLeadPathInRange(root.left, lo, hi, result);
		printRootLeadPathInRange(root.right, lo, hi, result);
		result.remove(result.size() - 1);
	}

	static class Traversal {
		ArrayList<Integer> pre = new ArrayList<>();
		ArrayList<Integer> in = new ArrayList<>();
		ArrayList<Integer> post = new ArrayList<>();

		Traversal() {
			pre = new ArrayList<>();
			in = new ArrayList<>();
			post = new ArrayList<>();
		}
	}

	public void preO(Node root, Traversal t) {
		if (root == null) {
			return;
		}
		t.pre.add(root.data);
		preO(root.left, t);
		preO(root.right, t);
	}

	public void postO(Node root, Traversal t) {
		if (root == null) {
			return;
		}
		postO(root.left, t);
		postO(root.right, t);
		t.post.add(root.data);
	}

	public void inO(Node root, Traversal t) {
		if (root == null) {
			return;
		}
		inO(root.left, t);
		t.in.add(root.data);
		inO(root.right, t);
	}

	public Node construct1(ArrayList<Integer> pre, ArrayList<Integer> in) {
		return construct1Helper(pre, in, 0, pre.size() - 1, 0, in.size() - 1);
	}

	private Node construct1Helper(ArrayList<Integer> pre, ArrayList<Integer> in, int preS, int preE, int inS, int inE) {
		if (inS > inE || preS > preE) {
			return null;
		}

		Node newNode = new Node(pre.get(preS));
		int lhs = 0;
		for (int j = inS; j <= inE; j++) {
			if (in.get(j) == pre.get(preS)) {
				break;
			} else {
				lhs++;
			}
		}
		newNode.left = construct1Helper(pre, in, preS + 1, preS + lhs, inS, inS + lhs - 1);
		newNode.right = construct1Helper(pre, in, preS + lhs + 1, preE, inS + lhs + 1, inE);

		return newNode;
	}

	public Node construct2(ArrayList<Integer> post, ArrayList<Integer> in) {
		return construct2Helper(post, in, 0, post.size() - 1, 0, in.size() - 1);
	}

	private Node construct2Helper(ArrayList<Integer> post, ArrayList<Integer> in, int postS, int postE, int inS,
			int inE) {

		if (inS > inE || postS > postE) {
			return null;
		}
		int lhs = 0;
		Node newNode = new Node(post.get(postE));
		for (int i = inS; i <= inE; i++) {
			if (in.get(i) == post.get(postE)) {
				break;
			} else {
				lhs++;
			}
		}
		newNode.left = construct2Helper(post, in, postS, postS + lhs - 1, inS, inS + lhs - 1);
		newNode.right = construct2Helper(post, in, postS + lhs, postE - 1, inS + lhs + 1, inE);
		return newNode;
	}

	// full trees - No single child
	public Node construct3(ArrayList<Integer> pre, ArrayList<Integer> post) {
		return construct3Helper(pre, post, 0, pre.size() - 1, 0, post.size() - 1);
	}

	private Node construct3Helper(ArrayList<Integer> pre, ArrayList<Integer> post, int preS, int preE, int postS,
			int postE) {
		if (preS > preE) {
			return null;
		}

		if (preS == preE) {
			Node node = new Node(pre.get(preE));
			node.left = null;
			node.right = null;
			return node;
		}

		int lhs = 1;
		Node newNode = new Node(pre.get(preS));
		for (int i = postS; i < postE; i++) {
			if (post.get(i) == pre.get(preS + 1)) {
				break;
			} else {
				lhs++;
			}
		}
		newNode.left = construct3Helper(pre, post, preS + 1, preS + lhs, postS, postS + lhs - 1);
		newNode.right = construct3Helper(pre, post, preS + lhs + 1, preE, postS + lhs, postE - 1);
		return newNode;
	}

	public Node construct4(int[] da, int[] pa) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		int rootVal = -1;
		for (int i = 0; i < pa.length; i++) {
			if (pa[i] == -1) {
				rootVal = da[i];
			}
			if (map.containsKey(pa[i])) {
				map.get(pa[i]).add(da[i]);
			} else {
				map.put(pa[i], new ArrayList<Integer>());
				map.get(pa[i]).add(da[i]);
			}
		}
		Node root = new Node(rootVal);

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);

		while (queue.isEmpty()) {
			Node frontNode = queue.getFirst();
			queue.removeFirst();
			ArrayList<Integer> child = map.get(frontNode.data);
			if (child == null) {
				frontNode.left = null;
				frontNode.right = null;
			} else {
				frontNode.left = new Node(child.get(0));
				frontNode.right = new Node(child.get(1));
				queue.addLast(frontNode.left);
				queue.addLast(frontNode.right);
			}
		}
		return root;
	}

	class D2 {
		int h, d;

		D2(int ih, int id) {
			this.h = ih;
			this.d = id;
		}
	}

	public int diameter(Node root) {
		if (root == null) {
			return 0;
		}
		int h1 = height(root.left);
		int h2 = height(root.right);
		return Math.max(Math.max(1 + h1 + h2, diameter(root.left)), diameter(root.right));
	}

	public D2 diameter2(Node root) {
		if (root == null) {
			D2 base = new D2(0, 0);
			return base;
		}
		D2 left = diameter2(root.left);
		D2 right = diameter2(root.right);

		D2 ans = new D2(Math.max(left.h, right.h) + 1, Math.max(Math.max(left.d, right.d), left.h + right.h + 1));
		return ans;
	}

	public boolean isBalancedNOTOPTIMIZED(Node root) {
		if (root == null) {
			return true;
		}
		boolean left = isBalancedNOTOPTIMIZED(root.left);
		if (left == false) {
			return false;
		}
		boolean right = isBalancedNOTOPTIMIZED(root.right);
		if (right == false) {
			return true;
		}
		int lh = height(root.left);
		int rh = height(root.right);
		int gap = lh - rh;
		if (gap < -1 || gap > 1) {
			return false;
		}
		return true;
	}

	class BalPair {
		int h;
		boolean isB;
	}

	public BalPair isBalanced(Node root) {
		if (root == null) {
			BalPair base = new BalPair();
			base.h = 0;
			base.isB = true;
			return base;
		}
		BalPair left = isBalanced(root.left);
		BalPair right = isBalanced(root.right);
		int gap = left.h - right.h;
		BalPair parent = new BalPair();
		parent.h = Math.max(left.h, right.h) + 1;
		parent.isB = left.isB && right.isB && gap >= -1 && gap <= 1;
		return parent;
	}

	public int min(Node root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int l = min(root.left);
		int r = min(root.right);
		return Math.min(Math.min(l, r), root.data);
	}

	class MMPair {
		int min;
		int max;
		boolean isBST;
		int lbstroot;
		int lbstsize;
	}

	// DO all the work in the post order traversal
	public MMPair isBST(Node root) {
		if (root == null) {
			MMPair mm = new MMPair();
			mm.max = Integer.MIN_VALUE;
			mm.min = Integer.MAX_VALUE;
			mm.isBST = true;
			mm.lbstroot = -1;
			mm.lbstsize = 0;
			return mm;
		}
		MMPair mleft = isBST(root.left);
		MMPair mright = isBST(root.right);
		MMPair mparent = new MMPair();
		mparent.min = Math.min(root.data, Math.min(mleft.min, mright.min));
		mparent.max = Math.max(root.data, Math.max(mleft.max, mright.max));
		mparent.isBST = mleft.isBST && mright.isBST && root.data > mleft.max && root.data < mright.min;

		if (mparent.isBST) {
			mparent.lbstroot = root.data;
			mparent.lbstsize = mleft.lbstsize + mright.lbstsize + 1;
		} else {
			if (mleft.lbstsize > mright.lbstsize) {
				mparent.lbstsize = mleft.lbstsize;
				mparent.lbstroot = mleft.lbstroot;
			} else {
				mparent.lbstsize = mright.lbstsize;
				mparent.lbstroot = mright.lbstroot;
			}
		}
		return mparent;
	}

	// Threaded Binary Tree -- Incomplete
	class TBT {
		int data;
		TBT left;
		TBT right;
		TBT nextRight;

		TBT(int id) {
			this.data = id;
		}
	}

	public void contructTBT(TBT root) {
		constructTBTHelper(root);
	}

	public TBT constructTBTHelper(TBT root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return root;
		}
		TBT left = constructTBTHelper(root.left);
		left.nextRight = root;
		TBT right = constructTBTHelper(root.right);
		return right;
	}

	// Construction of tree from PreOrder and InOrder
	public Node constructPreIn(ArrayList<Integer> pre, ArrayList<Integer> in) {
		return constructPreInHelper(pre, in, 0, pre.size() - 1, 0, in.size() - 1);
	}

	private Node constructPreInHelper(ArrayList<Integer> pre, ArrayList<Integer> in, int preStart, int preEnd,
			int inStart, int inEnd) {
		if (inStart > inEnd || preStart > preEnd) {
			return null;
		}
		if (inStart == inEnd) {
			return new Node(in.get(inStart));
		}
		Node newNode = new Node(pre.get(preStart));
		int left = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (pre.get(preStart) == in.get(i)) {
				break;
			} else {
				left++;
			}
		}
		newNode.left = constructPreInHelper(pre, in, preStart + 1, preStart + left, inStart, inStart + left - 1);
		newNode.right = constructPreInHelper(pre, in, preStart + left + 1, preEnd, inStart + left + 1, inEnd);
		return newNode;
	}

	// Construction of tree from PostOrder and InOrder
	public Node constructPostIn(ArrayList<Integer> post, ArrayList<Integer> in) {
		return constructPostInHelper(post, in, 0, post.size() - 1, 0, in.size() - 1);
	}

	private Node constructPostInHelper(ArrayList<Integer> post, ArrayList<Integer> in, int postStart, int postEnd,
			int inStart, int inEnd) {
		if (postStart > postEnd || inStart > inEnd) {
			return null;
		}
		if (inStart == inEnd) {
			return new Node(in.get(inStart));
		}
		Node newNode = new Node(post.get(postEnd));
		int left = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (in.get(i) == post.get(postEnd)) {
				break;
			} else {
				left++;
			}
		}
		newNode.left = constructPostInHelper(post, in, postStart, postStart + left - 1, inStart, inStart + left - 1);
		newNode.right = constructPostInHelper(post, in, postStart + left, postEnd - 1, inStart + left + 1, inEnd);
		return newNode;
	}

	// Construction of tree from PreOrder and PostOrder
	public Node constructPrePost(ArrayList<Integer> pre, ArrayList<Integer> post) {
		return constructPrePostHelper(pre, post, 0, pre.size() - 1, 0, post.size() - 1);
	}

	private Node constructPrePostHelper(ArrayList<Integer> pre, ArrayList<Integer> post, int preStart, int preEnd,
			int postStart, int postEnd) {
		if (preStart > preEnd || postStart > postEnd) {
			return null;
		}
		if (preStart == preEnd) {
			return new Node(pre.get(preStart));
		}
		Node newNode = new Node(pre.get(preStart));
		int left = 0;
		for (int i = postStart; i <= postEnd; i++) {
			if (post.get(i) == pre.get(preStart + 1)) {
				break;
			} else {
				left++;
			}
		}
		newNode.left = constructPrePostHelper(pre, post, preStart + 1, preStart + left + 1, postStart,
				postStart + left);
		newNode.right = constructPrePostHelper(pre, post, preStart + left + 2, preEnd, postStart + left + 1,
				postEnd - 1);
		return newNode;
	}

	// K Distance Nodes

	public ArrayList<Node> getPath(Node root, Node target) {
		if (root == null) {
			return null;
		}
		if (root == target) {
			ArrayList<Node> base = new ArrayList<>();
			base.add(root);
			return base;
		}
		ArrayList<Node> left = getPath(root.left, target);
		if (left != null) {
			left.add(root);
			return left;
		}
		ArrayList<Node> right = getPath(root.right, target);
		if (right != null) {
			right.add(root);
			return right;
		}
		return null;
	}

	public void nodesDown(Node root, int k, Node phb) {
		if (root == null || root == phb) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
		}
		nodesDown(root.left, k - 1, phb);
		nodesDown(root.right, k - 1, phb);
	}

	public void kdistance(Node root, Node target, int distance) {
		// Get path of the target from the root
		// Find K-down from each node in its path
		ArrayList<Node> path = getPath(root, target);
		Node prohibitor = null;
		for (int i = 0; i < path.size(); i++) {
			nodesDown(path.get(i), distance - i, prohibitor);
			prohibitor = path.get(i);
		}
	}

	public static void bottomView(Node root) {
		TreeMap<Integer, Integer> hmap = new TreeMap<>();
		int hd = 0;
		preTraversal(root, hmap, hd);
		for (int key : hmap.keySet()) {
			System.out.print(key + "->" + hmap.get(key) + " ");
		}
	}

	private static void preTraversal(Node root, TreeMap<Integer, Integer> hmap, int hd) {
		if (root == null) {
			return;
		}
		// Update the Map
		if (!hmap.containsKey(hd)) {
			hmap.put(hd, root.data);
		} else {
			hmap.put(hd, root.data);
		}
		preTraversal(root.left, hmap, hd - 1);
		preTraversal(root.right, hmap, hd + 1);
	}

	public static void main(String[] args) {
		Integer[] arr = { 50, 25, 12, -1, 37, 30, -1, 40, -1, -1, -1, 75, 62, 60, -1, 70, -1, -1, 87, -1, -1, -1 };
		Integer[] ar = { 50, 25, 12, -1, 37, 30, -1, -1, -1, 75, 62, 70, -1, -1, 87, -1, -1, -1 };
		ArrayList<Integer> dlist = new ArrayList<>(Arrays.asList(arr));
		BinaryTree bt = new BinaryTree();
		Integer[] arrPP = { 50, 25, 12, -1, 20, -1, -1, 75, 30, -1, 40, -1, -1, -1 };
		Integer[] arrBST = { 50, 25, 12, 10, -1, 15, 14, -1, 16, -1, -1, -1, 37, 24, -1, 40, -1, -1, -1, 75, 62, -1, 87,
				90, -1, -1, -1, -1 };
		ArrayList<Integer> dlistN = new ArrayList<>(Arrays.asList(arrBST));
		Node root = bt.construct(dlistN);
		// Node rootN = bt.construct(dlistN);
		// bt.display(root);
		// System.out.println();
		// System.out.println(bt.size(root));
		// System.out.println(bt.max(root));
		// System.out.println(bt.height(root));
		// System.out.println(bt.sum(root));
		// System.out.println();
		// System.out.println(bt.rootToNode(root, 75));
		/*
		 * System.out.println(bt.kDown(root, 2)); System.out.println(); isPresent =
		 * false; distanceNodes = new ArrayList<>(); bt.getPath(root, 75, 2);
		 * System.out.println(distanceNodes);
		 */
		// bt.kFar(root, 62, 2);
		// System.out.println();
		// bt.printRootLeadPathInRange(root, 0, 300, new ArrayList<>());
		// // System.out.println();
		// bt.display(root);
		// System.out.println();
		// bt.remove_Leaves(root);
		// System.out.println("------------------");
		// bt.display(root);

		/*
		 * System.out.println();
		 * 
		 * isPresent = false; distanceNodes = new ArrayList<>();
		 * 
		 * bt.getPath(root, 25, 2);
		 * 
		 * for (int element : distanceNodes) { System.out.println(element); }
		 */

		Traversal traversal = new Traversal();
		bt.preO(root, traversal);
		bt.postO(root, traversal);
		bt.inO(root, traversal);
		/// Node r1 = bt.construct1(traversal.pre, traversal.in);
		Node r1 = bt.constructPreIn(traversal.pre, traversal.in);
		// bt.display(r1);
		// System.out.println();
		// Node r2 = bt.construct2(traversal.post, traversal.in);
		Node r2 = bt.constructPostIn(traversal.post, traversal.in);
		// bt.display(r2);
		// System.out.println();
		int[] da = { 30, 40, 37, 12, 25, 75, 62, 87, 50 };
		int[] pa = { 37, 37, 25, 25, 50, 50, 75, 75, -1 };
		bt.construct4(da, pa);
		// bt.display(root);
		System.out.println();
		// Node r3 = bt.construct3(traversal.pre, traversal.post);
		Node r3 = bt.constructPrePost(traversal.pre, traversal.post);
		bt.display(r3);
		System.out.println(bt.diameter(root));
		System.out.println(bt.diameter2(root).d);
		System.out.println(bt.isBalancedNOTOPTIMIZED(root));
		System.out.println(bt.isBalanced(root).isB);
		System.out.println(bt.isBST(root).isBST);
		System.out.println(bt.isBST(root).lbstroot);
		System.out.println(bt.isBST(root).lbstsize);
		Node target = root.left.left.right;
		bt.kdistance(root, target, 2);
		bt.bottomView(root);
	}
}

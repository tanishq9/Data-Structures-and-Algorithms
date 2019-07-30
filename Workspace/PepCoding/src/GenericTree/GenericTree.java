package GenericTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class GenericTree {

	private static class Node {
		int data;
		ArrayList<Node> children;

		Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	public static Node construct(ArrayList<Integer> dlist) {
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
					ln.children.add(newNode);
				}
				nlist.add(newNode);
			}
		}
		return root;
	}

	public static void display(Node node) {
		String s = node.data + "->";
		for (int i = 0; i < node.children.size(); i++) {
			s += node.children.get(i).data + ",";
		}
		System.out.println(s += "END");
		for (int i = 0; i < node.children.size(); i++) {
			display(node.children.get(i));
		}
	}

	public int size(Node root) {
		int total = 0;
		for (int i = 0; i < root.children.size(); i++) {
			int recResult = size(root.children.get(i)); // HIGH LEVEL
			total += recResult;
		}
		return total + 1;
	}

	public int max(Node root) {
		int max = 0;
		for (int i = 0; i < root.children.size(); i++) {
			int recResult = max(root.children.get(i));
			max = Math.max(max, recResult);
		}
		return Math.max(max, root.data);
	}

	public int height(Node root) {
		int h = 0;
		for (int i = 0; i < root.children.size(); i++) {
			int recResult = height(root.children.get(i));
			h = Math.max(h, recResult);
		}
		return h + 1;
	}

	public boolean find(Node root, int data) {
		if (root.data == data) {
			return true;
		}
		for (int i = 0; i < root.children.size(); i++) {
			boolean isPresent = find(root.children.get(i), data);
			if (isPresent == true) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Integer> path(Node root, int data) {
		if (root.data == data) {
			ArrayList<Integer> br = new ArrayList<>();
			br.add(0, root.data);
			return br;
		}
		for (int i = 0; i < root.children.size(); i++) {
			ArrayList<Integer> rr = path(root.children.get(i), data);
			if (rr != null) {
				rr.add(0, root.data);
				return rr;
			}
		}
		return null;
	}

	public int lca(Node root, int d1, int d2) {
		ArrayList<Integer> path1 = path(root, d1);
		ArrayList<Integer> path2 = path(root, d2);
		int smaller = path1.size() > path2.size() ? path2.size() : path1.size();
		int latest = -1;
		// Diverge Logic
		for (int i = 0, j = 0; i < smaller; i++, j++) {
			if (path1.get(i) == path2.get(j)) {
				latest = path1.get(i);
			}
		}
		return latest;
	}

	public int distance(Node root, int d1, int d2) {
		ArrayList<Integer> path1 = path(root, d1);
		ArrayList<Integer> path2 = path(root, d2);
		ArrayList<Integer> pathLCA = path(root, lca(root, d1, d2));
		return path1.size() + path2.size() - 2 * pathLCA.size() + 1; // +1 is form lca which was subtracted twice
	}

	public void mirror(Node root) {
		for (int i = 0; i < root.children.size(); i++) {
			mirror(root.children.get(i));
		}
		int j = 0, k = root.children.size() - 1;
		while (j <= k) {
			Node ln = root.children.get(j);
			Node rn = root.children.get(k);
			root.children.set(j, rn);
			root.children.set(k, ln);
			j++;
			k--;
		}
	}

	public void removeLeaves(Node root) {
		for (int i = root.children.size() - 1; i >= 0; i--) {
			if (root.children.get(i).children.size() == 0) {
				root.children.remove(i);
			} else {
				removeLeaves(root.children.get(i));
			}
		}
	}

	public Node linearize2(Node root) {
		if (root.children.size() == 0) {
			return root; // Voh khudki tail hai
		}
		Node o = root.children.get(root.children.size() - 1);
		Node ot = linearize2(o);
		while (root.children.size() > 1) {
			Node sl = root.children.get(root.children.size() - 2);
			Node sltail = linearize2(sl);
			Node last = root.children.get(root.children.size() - 1);
			root.children.remove(root.children.size() - 1);
			sltail.children.add(last);
		}
		return ot;
	}

	public boolean areSimiliarStructure(Node root1, Node root2) {
		if (root1.children.size() != root2.children.size()) {
			return false;
		}
		for (int i = 0; i < root1.children.size(); i++) {
			boolean recResult = areSimiliarStructure(root1.children.get(i), root2.children.get(i));
			if (recResult == false) {
				return false;
			}
		}
		return true;
	}

	public boolean areMirrorStructure(Node root1, Node root2) {
		if (root1.children.size() != root2.children.size()) {
			return false;
		}
		for (int i = 0, j = root1.children.size() - 1; i < root1.children.size() && j >= 0; i++, j--) {
			boolean recResult = areMirrorStructure(root1.children.get(i), root2.children.get(j));
			if (recResult == false) {
				return false;
			}
		}
		return true;
	}

	public boolean isSymmetric(Node root) {
		return isSymmetric(root, root);
	}

	private boolean isSymmetric(Node root1, Node root2) {
		return areMirrorStructure(root1, root2);
		/*
		 * if (root1.children.size() != root2.children.size()) { return false; } for
		 * (int i = 0, j = root1.children.size() - 1; i < root1.children.size() && j >=
		 * 0; i++, j--) { boolean recResult = isSymmetric(root1.children.get(i),
		 * root2.children.get(j)); if (recResult == false) { return false; } } return
		 * true;
		 */ }

	private static class SecondLargest {
		int val = 0;
		int diff = Integer.MAX_VALUE;

		SecondLargest(int ival) {
			this.val = ival;
		}
	}

	public void secondLargest(Node root, int largest, SecondLargest secondLargest) {
		for (int i = 0; i < root.children.size(); i++) {
			int curr_val = root.children.get(i).data;
			// System.out.println(curr_val);
			int curr_diff = secondLargest.diff;
			int new_diff = largest - curr_val;
			if (curr_val != largest && Math.min(curr_diff, new_diff) == new_diff) {
				secondLargest.diff = new_diff;
				secondLargest.val = curr_val;
			}
			secondLargest(root.children.get(i), largest, secondLargest);
		}
	}

	public static class HeapMover {
		int sz = 0;
		int ht = 0;
		int mx = Integer.MIN_VALUE;
		int mn = Integer.MAX_VALUE;
	}

	public void multiSolver(Node root, int depth, HeapMover hm) {
		hm.sz++;
		hm.ht = depth > hm.ht ? depth : hm.ht;
		hm.mx = hm.mx < root.data ? root.data : hm.mx;
		hm.mn = hm.mn > root.data ? root.data : hm.mn;
		for (int i = 0; i < root.children.size(); i++) {
			multiSolver(root.children.get(i), depth + 1, hm);
		}
	}

	public static class FC {
		int ceil = -1;
		int floor = -1;
		int floorDiff = Integer.MAX_VALUE;
		int ceilDiff = Integer.MAX_VALUE;
	}

	public void floorceil(Node root, int data, FC fc) {
		// Outside for loop since it wont be checked for leave node otherwise
		int curr_val = root.data;
		if (data > curr_val) {
			if (Math.min(data - curr_val, fc.ceilDiff) == data - curr_val) {
				fc.ceilDiff = data - curr_val;
				fc.ceil = curr_val;
			}
		} else if (data < curr_val) {
			if (Math.min(fc.floorDiff, curr_val - data) == curr_val - data) {
				fc.floorDiff = curr_val - data;
				fc.floor = curr_val;
			}
		}

		for (int i = 0; i < root.children.size(); i++) {
			floorceil(root.children.get(i), data, fc);
		}
	}

	public static class PC {
		int status = 0; // Stop when status is 2
		int predecessor = -1; // Occurring just before in pre-order
		int successor = -1; // Occurring just after in post-order
	}

	public void predsuccStatus(Node root, int data, PC pc) {
		if (pc.status == 0) {
			if (root.data != data) {
				pc.predecessor = root.data;
			} else {
				pc.status++;
			}
		} else if (pc.status == 1) {
			pc.successor = root.data;
			pc.status++;
		}
		for (int i = 0; i < root.children.size(); i++) {
			predsuccStatus(root.children.get(i), data, pc);
		}
	}

	public static class CP {
		int curr = -1;
		int prev = -1;
		int pred = -1;
		int succ = -1;
	}

	public void predsuccCurrPrev(Node root, int data, CP cp) {
		cp.prev = cp.curr;
		cp.curr = root.data;
		if (cp.curr == data) {
			cp.pred = cp.prev;
		} else if (cp.prev == data) {
			cp.succ = cp.curr;
		}
		for (int i = 0; i < root.children.size(); i++) {
			predsuccCurrPrev(root.children.get(i), data, cp);
		}
	}

	/*
	 * static class KthFloor { int floor = -1; int floorDiff = Integer.MAX_VALUE; }
	 */

	static class KthCeil {
		int ceil = -1;
		int ceilDiff = Integer.MAX_VALUE;
	}

	// Debug
	public int kthSmallest(Node root, int k) {
		int r = 0;
		int data = Integer.MIN_VALUE; // Now , find ceil continuously
		for (int i = 0; i < k; i++) {
			KthCeil kc = new KthCeil();
			kthSmallestHelper(root, data, kc);
			data = kc.ceil;
			r = kc.ceil;
		}
		return r;
	}

	public void kthSmallestHelper(Node root, int data, KthCeil k) {
		int curr_val = root.data;
		if (data < curr_val) {
			if (Math.min(curr_val - data, k.ceilDiff) == curr_val - data) {
				k.ceilDiff = curr_val - data;
				k.ceil = curr_val;
			}
			/*
			 * if(curr_val < k.ceil) { k.ceil = curr_val; }
			 */
		}
		for (int i = 0; i < root.children.size(); i++) {
			kthSmallestHelper(root.children.get(i), data, k);
		}
	}

	// Bonus Question LATER
	public void diameter() {

	}

	public void levelOrder(Node root) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() != 0) {
			Node frontNode = queue.getFirst();
			queue.removeFirst();
			System.out.print(frontNode.data + ",");
			for (int i = 0; i < frontNode.children.size(); i++) {
				queue.addLast(frontNode.children.get(i));
			}
		}
		System.out.println("END");
	}

	static class Pair {
		Node node;
		int depth;

		Pair(Node iNode, int iDepth) {
			this.node = iNode;
			this.depth = iDepth;
		}
	}

	public void levelOrderLineWise(Node root) {
		LinkedList<Pair> queue = new LinkedList<>();
		queue.addFirst(new Pair(root, 0));
		int cd = 0;
		while (queue.size() != 0) {
			Pair front = queue.getFirst();
			Node frontNode = front.node;
			int depthFrontNode = front.depth;
			queue.removeFirst();
			if (depthFrontNode != cd) {
				System.out.println();
				cd = depthFrontNode;
			}
			System.out.print(frontNode.data + " ");
			for (int i = 0; i < frontNode.children.size(); i++) {
				queue.addLast(new Pair(frontNode.children.get(i), depthFrontNode + 1));
			}
		}
	}

	public void levelOrderLineWise2(Node root) {
		LinkedList<Node> q1 = new LinkedList<>();
		LinkedList<Node> q2 = new LinkedList<>();
		q1.add(root);
		while (q1.size() != 0) {
			Node frontNode = q1.getFirst();
			q1.removeFirst();
			System.out.print(frontNode.data + " ");
			for (int i = 0; i < frontNode.children.size(); i++) {
				q2.addLast(frontNode.children.get(i));
			}
			if (q1.size() == 0) {
				q1 = q2;
				q2 = new LinkedList<>();
				System.out.println();
			}
		}
	}

	public void zigzag(Node root) {
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		queue.add(root);
		boolean flag = true;
		while (queue.size() != 0) {
			Node frontNode = queue.getFirst();
			queue.removeFirst();
			System.out.print(frontNode.data + " ");
			if (flag) {
				for (int i = 0; i < frontNode.children.size(); i++) {
					stack.addFirst(frontNode.children.get(i));
				}
			} else {
				for (int i = frontNode.children.size() - 1; i >= 0; i--) {
					stack.addFirst(frontNode.children.get(i));
				}
			}
			if (queue.size() == 0) {
				queue = stack;
				stack = new LinkedList<>();
				System.out.println();
				flag = !flag;
			}
		}
	}

	public void dfs(Node root) {
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(root);
		while (stack.size() != 0) {
			Node frontNode = stack.getFirst();
			stack.removeFirst();
			System.out.print(frontNode.data + ",");
			for (int i = frontNode.children.size() - 1; i >= 0; i--) {
				stack.addFirst(frontNode.children.get(i));
			}
		}
		System.out.println("END");
	}

	public void dfsRecur(Node node) {
		// Node pre
		System.out.println(node.data + " pre");
		for (int i = 0; i < node.children.size(); i++) {
			// Edge pre
			dfsRecur(node.children.get(i));
			// Edge post
			System.out.println(node.data + " in");
		}
		// Node post
		System.out.println(node.data + " post");
	}

	static class EHelper {
		Node root;
		int state;

		EHelper(Node inode, int istate) {
			this.root = inode;
			this.state = istate;
		}
	}

	// DO
	public void euler(Node root) {
		LinkedList<EHelper> stack = new LinkedList<>();
		stack.addFirst(new EHelper(root, 0));
		while (stack.size() > 0) {
			EHelper eh = stack.getFirst();
			int cs = eh.root.children.size();
			if (eh.state == 0) {
				System.out.println(eh.root.data + " pre");
				eh.state++;
			} else if (eh.state >= 1 && eh.state <= cs) {
				Node ceh = eh.root.children.get(eh.state - 1);
				stack.addFirst(new EHelper(ceh, 0));
				if (eh.state >= 2) {
					System.out.println(eh.root.data + " In" + (eh.state - 1));
				}
				eh.state++;
			} else if (eh.state == cs + 1) {
				System.out.println(eh.root.data + " post");
				eh.state++;
			} else if (eh.state == cs + 2) {
				stack.removeFirst();
			}
		}
	}

	String[] keypad = { "", "abc", "def", "ghi", "jk", "lmno" };

	// KPC using DFS and BFS iteratively and not recursively
	public void kpc(String code) {
		// BFS using queue
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1,
				40, 100, -1, -1, -1 };
		ArrayList<Integer> dlist = new ArrayList<>(Arrays.asList(arr));
		GenericTree gt = new GenericTree();
		Node root = gt.construct(dlist);
		// display(root);
		/*
		 * System.out.println(gt.size(root)); System.out.println(gt.max(root));
		 * System.out.println(gt.find(root, 111)); System.out.println(gt.height(root));
		 * System.out.println(gt.path(root, 120)); System.out.println(gt.lca(root, 70,
		 * 120));
		 */
		// gt.mirror(root);
		// System.out.println();
		// gt.display(root);
		// System.out.println();
		// gt.removeLeaves(root);
		/*
		 * gt.display(root); gt.linearize2(root); System.out.println();
		 * gt.display(root);
		 */
		// Integer[] arr1 = new Integer[] { 1, 2, 4, -1, 5, -1, -1, 3, 6, -1, -1, -1 };
		// Integer[] arr1 = new Integer[] { 1, 2, 4, -1, 5, -1, -1, 3, -1, -1 };

		/*
		 * Integer[] arr1 = new Integer[] { 1, 2, 4, -1, 5, -1, -1, 3, 6, -1, -1, -1 };
		 * ArrayList<Integer> dlist1 = new ArrayList<>(Arrays.asList(arr1)); Node root1
		 * = gt.construct(dlist1);
		 * 
		 * Integer[] arr2 = new Integer[] { 1, 2, 4, -1, 5, -1, -1, 3, -1, -1 };
		 * ArrayList<Integer> dlist2 = new ArrayList<>(Arrays.asList(arr2)); Node root2
		 * = gt.construct(dlist2);
		 * 
		 * Integer[] arr3 = new Integer[] { 1, 3, 6, -1, -1, 2, 5, -1, 4, -1, -1, -1 };
		 * ArrayList<Integer> dlist3 = new ArrayList<>(Arrays.asList(arr3)); Node root3
		 * = gt.construct(dlist3);
		 * 
		 * Integer[] arr4 = new Integer[] { 1, 2, 4, -1, 5, -1, -1, 3, 6, -1, 7, -1, -1
		 * }; ArrayList<Integer> dlist4 = new ArrayList<>(Arrays.asList(arr4)); Node
		 * root4 = gt.construct(dlist4);
		 * 
		 * System.out.println(gt.areSimiliarStructure(root1, root2));
		 * System.out.println(gt.areMirrorStructure(root1, root3));
		 * System.out.println(gt.isSymmetric(root1));
		 * System.out.println(gt.isSymmetric(root4)); SecondLargest sl = new
		 * SecondLargest(-1); gt.secondLargest(root4, gt.max(root4), sl);
		 * System.out.println(sl.val);
		 */

		/*
		 * HeapMover hm = new HeapMover(); gt.multiSolver(root, 0, hm);
		 * System.out.println(hm.mx); FC fc = new FC(); gt.floorceil(root, 100, fc);
		 * System.out.println(fc.ceil); System.out.println(fc.floor); CP cp = new CP();
		 */
		/*
		 * gt.predsuccCurrPrev(root, 90, cp); System.out.println(cp.pred);
		 * System.out.println(cp.succ);
		 */
		// System.out.println(gt.kthSmallest(root, 5));
		/*
		 * gt.levelOrder(root); System.out.println(); gt.levelOrderLineWise(root);
		 * System.out.println(); System.out.println(); gt.levelOrderLineWise2(root);
		 * System.out.println(); gt.zigzag(root); System.out.println(); gt.dfs(root);
		 * System.out.println(); gt.dfsRecur(root); System.out.println();
		 */
		gt.euler(root);
	}

}

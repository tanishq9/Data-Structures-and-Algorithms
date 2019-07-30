package BinaryTree;

import java.util.ArrayList;

public class CONSTRUCT_Post_From_Pre_In {

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

	Node constructPreIn(ArrayList<Integer> pre, ArrayList<Integer> in) {
		return helper(pre, in, 0, pre.size() - 1, 0, in.size() - 1);
	}

	Node helper(ArrayList<Integer> pre, ArrayList<Integer> in, int preStart, int preEnd, int inStart, int inEnd) {

		if (inStart > inEnd || preStart > preEnd) {
			return null;
		}

		if (inStart == inEnd) {
			return new Node(in.get(inStart));
		}

		int lhs = 0; // left mei kitne bande hai
		for (int i = inStart; i <= inEnd; i++) {
			if (in.get(i) == pre.get(preStart)) {
				break;
			} else {
				lhs++;
			}
		}
		Node newNode = new Node(pre.get(preStart));
		newNode.left = helper(pre, in, preStart + 1, preStart + lhs, inStart, inStart + lhs - 1);
		newNode.right = helper(pre, in, preStart + lhs + 1, preEnd, inStart + lhs + 1, inEnd);
		return newNode;
	}

}

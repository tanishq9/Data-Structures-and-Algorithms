package BinaryTree;

import java.util.ArrayList;

public class CONSTRUCT_Pre_From_Post_In {
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

	Node constructPostIn(ArrayList<Integer> post, ArrayList<Integer> in) {
		return helper(post, in, 0, post.size() - 1, 0, in.size() - 1);
	}

	Node helper(ArrayList<Integer> post, ArrayList<Integer> in, int postStart, int postEnd, int inStart, int inEnd) {

		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}

		if (inStart == inEnd) {
			return new Node(in.get(inStart));
		}

		int lhs = 0; // left mei kitne bande hai
		for (int i = inStart; i <= inEnd; i++) {
			if (in.get(i) == post.get(postEnd)) {
				break;
			} else {
				lhs++;
			}
		}
		Node newNode = new Node(post.get(postEnd));
		newNode.left = helper(post, in, postStart, postStart + lhs - 1, inStart, inStart + lhs - 1);
		newNode.right = helper(post, in, postStart + lhs, postEnd - 1, inStart + lhs + 1, inEnd);
		return newNode;
	}
}

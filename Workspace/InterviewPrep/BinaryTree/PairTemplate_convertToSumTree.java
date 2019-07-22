package BinaryTree;

class Tree {
	int data;
	Tree left, right;

	Tree(int d) {
		data = d;
		left = null;
		right = null;
	}

	public class PairTemplate_convertToSumTree {
		class CS {
			int val;
			int downsum;
		}

		public void toSumTree(Tree root) {
			// add code here.
			helper(root);
		}

		CS helper(Tree root) {
			if (root == null) {
				CS base = new CS();
				base.val = 0;
				base.downsum = 0;
				return base;
			}
			CS left = helper(root.left);
			CS right = helper(root.right);
			CS parent = new CS();
			parent.val = root.data;
			parent.downsum = left.val + left.downsum + right.val + right.downsum;
			root.data = parent.downsum;
			return parent;
		}
	}
}

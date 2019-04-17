package BinaryTree;

public class AllPathsFromRootToLeaf {
	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) {
	 *      val = x;
	 *      left=null;
	 *      right=null;
	 *     }
	 * }
	 */
	/*
	 * public class Solution { ArrayList<ArrayList<Integer>> result = null; public
	 * ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) { result = new
	 * ArrayList<ArrayList<Integer>>(); pathSumHelper(A,B,new ArrayList<Integer>());
	 * return result; } private void pathSumHelper(TreeNode A,int
	 * B,ArrayList<Integer> list){ // Empty List Base case if (A == null) { return;
	 * } // If that's a root node then consider if the sum matches if (A.left ==
	 * null && A.right == null) { if (A.val == B) { list.add(A.val);
	 * result.add((ArrayList<Integer>)list.clone()); list.remove(list.size() - 1); }
	 * return; } list.add(A.val); pathSumHelper(A.left, B-A.val, list);
	 * pathSumHelper(A.right, B-A.val, list); // When both the left and right path
	 * of the tree have been explored then I would // remove that node
	 * list.remove(list.size() - 1); } }
	 */
}

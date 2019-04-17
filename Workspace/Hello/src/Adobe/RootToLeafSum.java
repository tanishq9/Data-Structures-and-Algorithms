package Adobe;

public class RootToLeafSum {
	/**
	 * Definition for binary tree class TreeNode { int val; TreeNode left; TreeNode
	 * right; TreeNode(int x) { val = x; left=null; right=null; } }
	 */
	/*
	 * public class Solution { private ArrayList<Integer> list = null;
	 * 
	 * public int sumNumbers(TreeNode A) { list = new ArrayList<>(); sumNumbers(A,
	 * ""); int sum = 0; for (int i = 0; i < list.size(); i++) { //
	 * System.out.print(list.get(i)+" "); } for (int i = 0; i < list.size(); i++) {
	 * sum = (sum + list.get(i)); } return sum % 1003; }
	 * 
	 * private void sumNumbers(TreeNode node, String res) { if (node == null) {
	 * return; } if (node.left == null && node.right == null) { res = res +
	 * node.val; StringBuilder sb = new StringBuilder(res); int num = 0; for (int i
	 * = 0; i < sb.length(); i++) { num = (num * 10 + sb.charAt(i) - '0') % 1003; }
	 * list.add(num); return; } sumNumbers(node.left, res + node.val);
	 * sumNumbers(node.right, res + node.val); return; } }
	 * 
	 */}

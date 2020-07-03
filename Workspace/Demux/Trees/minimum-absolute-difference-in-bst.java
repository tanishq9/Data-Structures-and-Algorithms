/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode pred;
    int min;
    public int getMinimumDifference(TreeNode root) {
        pred=null;
        min=Integer.MAX_VALUE;
        getMinDiff(root);
        return min;
    }
    void getMinDiff(TreeNode root){
        if(root==null){
            return;
        }
        getMinDiff(root.left);
        if(pred!=null) min=Math.min(min,root.val-pred.val);
        pred=root;
        getMinDiff(root.right);
    }
}
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
    int max;
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int lval=helper(root.left); 
        // gives path value for tree rooted at root.left
        // that always end at the leaf everytime and this is evident from return value
        int rval=helper(root.right);
        // gives path value for tree rooted at root.right
        // that always end at the leaf everytime and this is evident from return value
        int rv=Math.max(lval,rval)+root.val;
        max=Math.max(max,rv);
        return rv;
    }   
}
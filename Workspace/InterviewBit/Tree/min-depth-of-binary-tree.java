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
public class Solution {
    public int minDepth(TreeNode A) {
        return helper(A);
    }
    int helper(TreeNode root){
        if(root==null){
            return Integer.MAX_VALUE;
        }  
        if(root.left==null && root.right==null){
            return 1;
        }
        int l=helper(root.left);
        int r=helper(root.right);
        return Math.min(l,r)+1;
    }
}

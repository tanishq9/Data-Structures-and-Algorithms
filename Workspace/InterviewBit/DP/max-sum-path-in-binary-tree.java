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
    int max;
    public int maxPathSum(TreeNode A) {
        max=Integer.MIN_VALUE;
        helper(A);
        return max;
    }
    int helper(TreeNode A){
        if(A==null){
            return 0;
        }
        int l=helper(A.left); // max sum path rooted at root.left 
        int r=helper(A.right); // max sum path rooted at root.right
        int rv=Math.max(A.val,Math.max(A.val+l,A.val+r));
        max=Math.max(max,Math.max(rv,A.val+l+r));
        return rv;
    }
}
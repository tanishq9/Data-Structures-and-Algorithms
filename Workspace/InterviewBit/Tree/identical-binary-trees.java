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
    public int isSameTree(TreeNode A, TreeNode B) {
        return dfs(A,B)?1:0;
    }
    boolean dfs(TreeNode A, TreeNode B){
        if(A==null && B==null){
            return true;
        }
        if(A==null || B==null){
            return false;
        }
        return A.val==B.val && dfs(A.left,B.left) && dfs(A.right,B.right);
    }
}

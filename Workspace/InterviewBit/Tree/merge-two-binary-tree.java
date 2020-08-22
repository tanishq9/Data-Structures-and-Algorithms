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
    public TreeNode solve(TreeNode A, TreeNode B) {
        if(A==null && B==null){
            return null;
        }
        if(A!=null && B==null){
            return A;
        }
        if(A==null && B!=null){
            return B;
        }
        // else if both are not null
        A.val+=B.val;
        TreeNode left=solve(A.left,B.left);
        TreeNode right=solve(A.right,B.right);
        A.left=left;
        A.right=right;
        return A;
    }
}

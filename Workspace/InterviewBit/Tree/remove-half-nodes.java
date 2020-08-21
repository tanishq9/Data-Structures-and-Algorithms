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
    public TreeNode solve(TreeNode A) {
        // 15 29 10 15 -1 -1 29 -1 3 2 1 -1 -1 -1 -1 -1
        if(A==null){
            return null;
        }
        A.left=solve(A.left);
        A.right=solve(A.right);
        // work in post order, bottom up manner
        if(A.left==null && A.right==null){
            return A;
        }else if(A.left==null && A.right!=null){
            return A.right;
        }else if(A.left!=null && A.right==null){
            return A.left;
        }
        return A;
    }
}

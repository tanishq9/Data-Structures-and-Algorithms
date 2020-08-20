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
    public int lca(TreeNode A, int B, int C) {
        if(!find(A,B) || !find(A,C)){
            return -1;
        }
        // below function only works if both the values exist in the tree
        TreeNode a=dfs(A,B,C);
        return a!=null?a.val:-1;
    }
    
    boolean find(TreeNode A,int B){
        if(A==null){
            return false;
        }
        if(A.val==B){
            return true;
        }
        boolean l=find(A.left,B);
        boolean r=find(A.right,B);
        if(l || r){
            return true;
        }else{
            return false;
        }
    }
    
    TreeNode dfs(TreeNode root,int B,int C){
        if(root==null){
            return null;
        }
        if(root.val==B || root.val==C){
            return root;
        }
        // this will tell whether we get either of B or C 
        TreeNode left=dfs(root.left,B,C);
        TreeNode right=dfs(root.right,B,C);
        if(left!=null && right!=null){
            return root;
        }else if(left!=null && right==null){
            return left;
        }else if(left==null && right!=null){
            return right;
        }else{
            return null;
        }
    }
}

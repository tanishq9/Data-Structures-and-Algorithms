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
    TreeNode pred,first,second;
    public void recoverTree(TreeNode root) {
        pred=null;
        first=null;
        second=null;
        helper(root);
        // we have first and second node
        // now we need to swap there values
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        // get the 2 exchanged nodes
        if(pred!=null){
            if(first==null && pred.val>root.val){
                first=pred;
            }
            if(first!=null && pred.val>root.val){
                second=root;
            }
        }
        pred=root;
        helper(root.right);
    }
}
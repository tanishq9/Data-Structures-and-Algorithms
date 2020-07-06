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
    int val,max=0;
    public int findBottomLeftValue(TreeNode root) {
        val=0;
        helper(root,1);
        return val;
    }
    void helper(TreeNode root,int h){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            if(h>max){
                max=h;
                val=root.val;
            }
            return;
        }
        helper(root.left,h+1);
        helper(root.right,h+1);
    }
}
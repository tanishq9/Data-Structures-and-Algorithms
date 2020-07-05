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
    public TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return null;
        }
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);    
        // if the leave node is 1 then that whole subtree has to be taken
        // else incase of 0 we can return null as that path should not be considered
        if(root.left==null && root.right==null && root.val!=1){
            return null;
        }else{
            return root;
        }
    }
}
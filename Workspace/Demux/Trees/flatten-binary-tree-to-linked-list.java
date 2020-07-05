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
    
    class Pair{
        TreeNode head;
        TreeNode tail;
    }
    
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        root=helper(root).head;
    }
    
    Pair helper(TreeNode root){
        if(root==null){
            return null;
        }
        else if(root.left==null && root.right==null){
            Pair base=new Pair();
            base.head=root;
            base.tail=root;
            return base;
        }
        else if(root.left==null && root.right!=null){
            Pair rightNode=helper(root.right);
            // assign the head and tail
            Pair mp=new Pair();
            mp.head=root;
            mp.tail=rightNode.tail;
            return mp;
        }
        else if(root.left!=null && root.right==null){
            Pair leftNode=helper(root.left);
            // remove left child as the flattened tree is right skewed
            // assign the left as right node of the current root
            root.right=leftNode.head;
            root.left=null;
            // assign new head and tail
            Pair mp=new Pair();
            mp.head=root;
            mp.tail=leftNode.tail;
            return mp;
        }
        else{
            Pair leftNode=helper(root.left);
            Pair rightNode=helper(root.right);
            // assign right as the new the right child of left subtree
            // and remove the current right node of the root
            leftNode.tail.right=rightNode.head;
            root.right=null;
            // now reassign the right node for the current root
            root.right=leftNode.head;
            root.left=null;
            // assign head and tail
            Pair mp=new Pair();
            mp.head=root;
            mp.tail=rightNode.tail;
            return mp;
        }
    }
    
}
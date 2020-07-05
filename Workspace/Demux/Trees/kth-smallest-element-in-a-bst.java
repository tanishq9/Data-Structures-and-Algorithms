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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        while(stack.size()>0 || root!=null){
            // making sure the min value is always on top of stack
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            // get the lowest value(since it is leftmost)
            root=stack.pop();
            if(--k==0){
                return root.val;
            }
            // move to the right node and later traverse its left subtree
            // to get to the other smaller nodes
            root=root.right;
        }
        return -1;
    }
}
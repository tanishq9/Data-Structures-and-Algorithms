/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode getSuccessor(TreeNode a, int b) {
        Stack<TreeNode> stack=new Stack<>();
        while(stack.size()>0 || a!=null){
            while(a!=null){
                stack.push(a);
                a=a.left;
            }
            TreeNode peek=stack.pop();
            if(peek.val>b){
                return peek;
            }
            a=peek.right;
        }
        return null;
    }
}

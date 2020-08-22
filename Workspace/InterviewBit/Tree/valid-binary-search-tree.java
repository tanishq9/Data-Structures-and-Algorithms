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
    public int isValidBST(TreeNode A) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode prev=null;
        while(stack.size()>0 || A!=null){
            while(A!=null){
                stack.push(A);
                A=A.left;
            }
            TreeNode top=stack.pop();
            if(prev!=null){
                if(top.val<=prev.val){
                    return 0;
                }
            }
            prev=top;
            A=top.right;
        }
        return 1;
    }
}

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
    public int kthsmallest(TreeNode A, int B) {
        Stack<TreeNode> stack=new Stack<>();
        int counter=0;
        while(stack.size()>0 || A!=null){
            while(A!=null){
                stack.push(A);
                A=A.left;
            }
            TreeNode top=stack.pop();
            if(++counter==B){
                return top.val;
            }
            A=top.right;
        }
        return -1;
    }
}

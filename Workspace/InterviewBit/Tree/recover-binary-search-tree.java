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
    TreeNode n1,n2,prev;
    public ArrayList<Integer> recoverTree(TreeNode A) {
        n1=null;
        n2=null;
        prev=null;
        helper(A);
        ArrayList<Integer> result=new ArrayList<>();
        result.add(n2.val);
        result.add(n1.val);
        return result;        
    }
    void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        if(prev!=null){
            if(prev.val>root.val && n1==null){
                n1=prev;
            }
            if(prev.val>root.val && n1!=null){
                n2=root;
            }
        }
        prev=root;
        helper(root.right);
    }
    
}

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
    
    TreeNode helper(int[] pre,int pres,int pree,int[] in,int ins,int ine){ 
        if(pres>pree || ins>ine){
            return null;
        }
        int idx=-1;
        for(int i=ins;i<=ine;i++){
            if(in[i]==pre[pres]){
                idx=i;
                break;
            }
        }
        int lhs=idx-ins;
        TreeNode node=new TreeNode(pre[pres]);
        node.left=helper(pre,pres+1,pres+lhs,in,ins,idx-1);
        node.right=helper(pre,pres+lhs+1,pree,in,idx+1,ine);
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
}
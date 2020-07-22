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
    class OBJ{
        boolean isBST;
        int val;
        int sum;
        int max;
        int min;
    }
    int max;
    public int maxSumBST(TreeNode root) {
        max=Integer.MIN_VALUE;
        helper(root);
        return max<0?0:max;
    }
    
    OBJ helper(TreeNode root){
        
        if(root==null){
            OBJ base=new OBJ();
            base.val=-1;
            base.sum=0;
            base.min=Integer.MAX_VALUE;
            base.max=Integer.MIN_VALUE;
            base.isBST=true;
            return base; 
        }
    
        OBJ parent=new OBJ();
        
        OBJ left=helper(root.left);
        OBJ right=helper(root.right);
        
        parent.val=root.val;
        parent.max=Math.max(parent.val,right.max);
        parent.min=Math.min(parent.val,left.min);
        
        parent.isBST=(left.isBST && right.isBST && parent.val>left.max && root.val<right.min);
         
        if(parent.isBST){
            parent.sum=left.sum+right.sum+parent.val;
        }else{
            if(left.sum>right.sum){
                parent.sum=left.sum;
            }else{
                parent.sum=right.sum;
            }
        }
        max=Math.max(max,parent.sum);
        return parent;
        
    }
}
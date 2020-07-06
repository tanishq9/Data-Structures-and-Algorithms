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
    
    public TreeNode helper(int[] pre,int pres,int pree,int[] post,int posts,int poste){
        if(pres>pree){
            return null;
        }
        if(pres==pree){
            return new TreeNode(pre[pres]);
        }
        int idx=-1;
        // look for pre[pres+1] index in post array
        for(int i=posts;i<=poste;i++){
            if(post[i]==pre[pres+1]){
                idx=i;
                break;
            }
        }
        int lhs=idx-posts+1; // +1 kyuki voh element bhi include hoga
        TreeNode node=new TreeNode(pre[pres]);
        node.left=helper(pre,pres+1,pres+lhs,post,posts,posts+lhs-1);
        node.right=helper(pre,pres+lhs+1,pree,post,posts+lhs,poste-1);
        return node;
    }
    
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre,0,pre.length-1,post,0,post.length-1);
    }
}
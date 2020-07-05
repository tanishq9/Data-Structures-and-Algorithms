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
   

    // ONLY POSSIBLE FOR FULL BINARY TREES
 
    TreeNode helper(int[] post,int posts,int poste,int[] in,int pres,int pree){
        if(posts>poste || pres>pree){
            return null;
        }
        // find the node next to current node in the postorder array
        // as it will help us to make boundaries
	// use that index where the current node is found 
        // to assign left and right for this current node
        int idx=-1;
        for(int i=posts;i<=poste;i++){
            if(post[i]==pre[pres+1]){
                idx=i;
                break;
            }
        }
        int lhs=idx-ins+1; // +1 kyuki voh banda bhi includ karna hai
        TreeNode node=new TreeNode(pre[pres]);
        node.left=helper(post,posts,posts+lhs-1,pre,pres+1,pres+lhs);
        node.right=helper(post,posts+lhs,poste-1,pre,pres+lhs+1,pree);
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] postorder) {
        return helper(postorder,0,postorder.length-1,preorder,0,preorder.length-1);
    }
}
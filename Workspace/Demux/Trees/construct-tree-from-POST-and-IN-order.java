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
    
    TreeNode helper(int[] post,int posts,int poste,int[] in,int ins,int ine){
        if(posts>poste || ins>ine){
            return null;
        }
        // find the current root node in the inorder array
        // use that index where the current node is found 
        // to assign left and right for this current node
        int idx=-1;
        for(int i=ins;i<=ine;i++){
            if(in[i]==post[poste]){
                idx=i;
                break;
            }
        }
        int lhs=idx-ins;
        TreeNode node=new TreeNode(post[poste]);
        node.left=helper(post,posts,posts+lhs-1,in,ins,idx-1);
        node.right=helper(post,posts+lhs,poste-1,in,idx+1,ine);
        return node;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }
}
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
    public TreeNode buildTree(int[] A, int[] B) {
        return dfs(A,B,0,A.length-1,0,B.length-1);
    }
    TreeNode dfs(int[] in,int[] post,int ins,int ine,int posts,int poste){
        if(posts>poste){
            return null;
        }
        int rootIndex=ins;
        for(int i=ins;i<=ine;i++){
            if(in[i]==post[poste]){
                rootIndex=i;
                break;
            }
        }
        int numElementsOnLeft=rootIndex-ins;
        TreeNode root=new TreeNode(post[poste]);
        root.left=dfs(in,post,ins,rootIndex-1,posts,posts+numElementsOnLeft-1);
        root.right=dfs(in,post,rootIndex+1,ine,posts+numElementsOnLeft,poste-1);
        return root;
    }
}

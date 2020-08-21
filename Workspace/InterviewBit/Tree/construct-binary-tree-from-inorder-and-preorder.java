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
    TreeNode dfs(int[] pre,int[] in,int pres,int pree,int ins,int ine){
        if(pres>pree){
            return null;
        }
        int rootIndex=ins;
        for(int i=ins;i<=ine;i++){
            if(in[i]==pre[pres]){
                rootIndex=i;
                break;
            }
        }
        int numElementsOnLeft=rootIndex-ins;
        TreeNode root=new TreeNode(pre[pres]);
        root.left=dfs(pre,in,pres+1,pres+numElementsOnLeft,ins,rootIndex-1);
        root.right=dfs(pre,in,pres+numElementsOnLeft+1,pree,rootIndex+1,ine);
        return root;
    }
}

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
    public TreeNode buildTree(int[] A) {
        return dfs(A,0,A.length-1);
    }
    TreeNode dfs(int[] A,int s,int e){
        if(s>e){
            return null;
        }
        if(s==e){
            return new TreeNode(A[s]);
        }
        int maxIndex=s;
        for(int i=s;i<=e;i++){
            if(A[i]>A[maxIndex]){
                maxIndex=i;
            }
        }
        TreeNode root=new TreeNode(A[maxIndex]);
        root.left=dfs(A,s,maxIndex-1);
        root.right=dfs(A,maxIndex+1,e);
        return root;
    }
}

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
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(List<Integer> A) {
        return dfs(A,0,A.size()-1);
    }
    TreeNode dfs(List<Integer> A,int s,int e){
        if(s>e){
            return null;
        }
        if(s==e){
            return new TreeNode(A.get(s));
        }
        int mid=(s+e)/2;
        TreeNode root=new TreeNode(A.get(mid));
        root.left=dfs(A,s,mid-1);
        root.right=dfs(A,mid+1,e);
        return root;
    }
}

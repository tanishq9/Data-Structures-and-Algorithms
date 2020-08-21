/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    class Pair{
        TreeNode start;
        TreeNode end;
        Pair(TreeNode is,TreeNode ie){
            this.start=is;
            this.end=ie;
        }
    }
    public TreeNode flatten(TreeNode root) {
        return dfs(root).start;
    }
    // Using Exhaustive Pattern i.e explicitly covering all types of nodes
    Pair dfs(TreeNode root){
        if(root.left==null && root.right==null){
            return new Pair(root,root);
        }else if(root.left!=null && root.right==null){
            Pair l=dfs(root.left);
            root.left=null;
            root.right=l.start;
            return new Pair(root,l.end);
        }else if(root.left==null && root.right!=null){
            Pair r=dfs(root.right);
            root.right=r.start;
            return new Pair(root,r.end);
        }else{
            Pair l=dfs(root.left);
            Pair r=dfs(root.right);
            root.left=null;
            root.right=l.start;
            l.end.right=r.start;
            return new Pair(root,r.end);
        }
    }
}

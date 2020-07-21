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
    class Pair{
        int lmax;
        int rmax;
        Pair(int il,int ir){
            this.lmax=il;
            this.rmax=ir;
        }
    }
    int max;
    public int longestZigZag(TreeNode root) {
        max=0;
        helper(root);
        return max;
    }
    Pair helper(TreeNode root){
        if(root==null){
            return new Pair(-1,-1);
        }
        if(root.left==null && root.right==null){
            return new Pair(0,0);
        }
        Pair lchild=helper(root.left);
        Pair rchild=helper(root.right);
        max=Math.max(max,Math.max(lchild.rmax+1,rchild.lmax+1));
        // left child ke right child mei max zigzag path kya hai ? -> base level
        // left child ke right child ke left child ko lekar max path -> thoda intuitive
        return new Pair(lchild.rmax+1,rchild.lmax+1);
    }
}
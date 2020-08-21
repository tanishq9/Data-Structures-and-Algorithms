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
    class Pair{
        boolean isbalanced;
        int height;
        Pair(boolean isb,int ih){
            this.isbalanced=isb;
            this.height=ih;
        }
    }
    public int isBalanced(TreeNode A) {
        // work will be done in post order because the order of processing is L R N
        // i.e left child -> right child -> node and it helps us to compare the left and right child values and take decision at the node level
        return helper(A).isbalanced==true?1:0;
    }
    Pair helper(TreeNode A){
        if(A==null){
            return new Pair(true,0);
        }
        Pair left=helper(A.left);
        Pair right=helper(A.right);
        if(left.isbalanced && right.isbalanced && Math.abs(left.height-right.height)<=1){
            return new Pair(true,Math.max(left.height,right.height)+1);
        }else{
            // if the left or right tree is not balanced then height doesn't matter
            return new Pair(false,-1);
        }
    }
}

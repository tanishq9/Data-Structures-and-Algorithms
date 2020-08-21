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
    public ArrayList<Integer> solve(TreeNode A, int B) {
        if(A==null){
            return null;
        }
        if(A.val==B){
            ArrayList<Integer> base=new ArrayList<>();
            base.add(B);
            return base;
        }
        ArrayList<Integer> left=solve(A.left,B);
        if(left!=null){
            left.add(0,A.val);
            return left;
        }
        ArrayList<Integer> right=solve(A.right,B);
        if(right!=null){
            right.add(0,A.val);
            return right;
        }
        return null;
    }
}

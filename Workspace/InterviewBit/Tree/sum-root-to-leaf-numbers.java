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
    public int sumNumbers(TreeNode A) {
        return helper(A,0);
    }
    int helper(TreeNode root,int sum){
        if(root==null){
            // return 0 if not a leaf path
            return 0;
        }
        if(root.left==null && root.right==null){
            // return the whole path sum if path ends at a leaf node
            return (10*sum+root.val)%1003;
        }
        int left=helper(root.left,((10*sum)%1003+root.val%1003)%1003);
        int right=helper(root.right,((10*sum)%1003+root.val%1003)%1003);
        return (left%1003+right%1003)%1003;
    }
}

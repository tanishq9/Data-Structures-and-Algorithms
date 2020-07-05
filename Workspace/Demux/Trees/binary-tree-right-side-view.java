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
    int max;
    public List<Integer> rightSideView(TreeNode root) {
        max=0;
        ArrayList<Integer> list=new ArrayList<>();
        helper(root,1,list);
        return list;
    }
    void helper(TreeNode root,int cl,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        if(cl>max){
            max=cl;
            list.add(root.val);
        }
        helper(root.right,cl+1,list);
        helper(root.left,cl+1,list);
        
    }
}
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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res=new ArrayList<>();
        fun(root,sum,new ArrayList<>());
        return res;
    }
    // REACTIVE
    void fun(TreeNode root,int sum,List<Integer> list){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            if(sum-root.val==0){
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(root.val);
        fun(root.left,sum-root.val,list);
        fun(root.right,sum-root.val,list);
        // removing elements in post order once they have been considered 
        // in all possible paths
        list.remove(list.size()-1);
    }
}
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
    int total;
    public int pathSum(TreeNode root, int sum) {
        total=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        helper(root,sum,0,map);
        return total;
    }
    void helper(TreeNode root,int target,int runningSum,HashMap<Integer,Integer> hmap){
        if(root==null){
            return;
        }
        runningSum+=root.val;
        // check for targetSum
        total+=hmap.getOrDefault(runningSum-target,0);
        
        hmap.put(runningSum,hmap.getOrDefault(runningSum,0)+1);
        
        helper(root.left,target,runningSum,hmap);
        helper(root.right,target,runningSum,hmap);
        
        // in post order, remove the value 
        hmap.put(runningSum,hmap.getOrDefault(runningSum,0)-1);
        runningSum-=root.val;
    }
}
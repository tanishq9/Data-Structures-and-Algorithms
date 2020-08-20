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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        dfs(A,B,new ArrayList<Integer>(),result);
        return result;
    }
    void dfs(TreeNode root,int sum,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> result){
        if(root==null){
            // just return as it is not a root to leaf path
            return;
        }
        if(root.left==null && root.right==null){
            if(sum-root.val==0){
                temp.add(root.val);
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            return;
        }
        // adding element in the pre order
        temp.add(root.val);
        dfs(root.left,sum-root.val,temp,result);
        dfs(root.right,sum-root.val,temp,result);
        // removing element in the post order as it won't be considered later
        temp.remove(temp.size()-1);
    }
}

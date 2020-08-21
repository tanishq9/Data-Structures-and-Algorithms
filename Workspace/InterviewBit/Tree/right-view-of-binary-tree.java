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
    int maxlvl;
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> res=new ArrayList<>();
        maxlvl=0;
        dfs(A,1,res);
        return res;
    }
    void dfs(TreeNode node,int lvl,ArrayList<Integer> res){
        if(node==null){
            return;
        }
        if(maxlvl<lvl){
            maxlvl=lvl;
            res.add(node.val);
        }
        dfs(node.right,lvl+1,res);
        dfs(node.left,lvl+1,res);
    }
}

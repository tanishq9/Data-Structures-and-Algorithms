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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        LinkedList<TreeNode> q=new LinkedList<>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        q.add(A);
        while(q.size()>0){
            int sz=q.size();
            ArrayList<Integer> temp=new ArrayList<Integer>();
            while(sz-->0){
                TreeNode fr=q.removeFirst();
                temp.add(fr.val);
                if(fr.left!=null){
                    q.addLast(fr.left);
                }
                if(fr.right!=null){
                    q.addLast(fr.right);
                }
            }
            if(temp!=null){
                res.add(temp);
            }
        }
        return res;
    }
}
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
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        LinkedList<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int cnt=q.size();
            int max=Integer.MIN_VALUE;
            while(cnt-->0){
                TreeNode fr=q.removeFirst();
                max=Math.max(max,fr.val);
                if(fr.left!=null){
                    q.add(fr.left);
                }
                if(fr.right!=null){
                    q.add(fr.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}
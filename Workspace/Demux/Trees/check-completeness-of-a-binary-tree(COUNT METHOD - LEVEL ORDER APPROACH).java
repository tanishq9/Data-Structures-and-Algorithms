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
    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean gotNull=false;
        while(q.size()>0){
            int count=q.size();
            while(count-->0){
                TreeNode front=q.removeFirst();
                // matlab ek baar humne null node
                // encounter krlia toh uske baad
                // saare null node hi hone chahiye
                // nhi toh we can say that the filling
                // is not done from left to right 
                // and hence not a complete bt
                if(front!=null && gotNull==true){
                    return false;
                }
                // if null node, mark gotNull as true
                if(front==null){
                    gotNull=true;
                    continue;
                }
                q.addLast(front.left);
                q.addLast(front.right);  
            }
        }
        return true;
    }
}
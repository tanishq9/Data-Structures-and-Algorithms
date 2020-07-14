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
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> q=new LinkedList<>();
        q.add(root);
        int max=Integer.MIN_VALUE,maxl=1,lvl=1;
        while(q.size()>0){
            int c=q.size(),cs=0;
            while(c-->0){
                TreeNode fr=q.removeFirst();
                cs+=fr.val;
                if(fr.left!=null){
                    q.add(fr.left);
                }
                if(fr.right!=null){
                    q.add(fr.right);
                }
            }
            if(cs>max){
                max=cs;
                maxl=lvl;
            }
            lvl+=1;
        }
        return maxl;
    }
}
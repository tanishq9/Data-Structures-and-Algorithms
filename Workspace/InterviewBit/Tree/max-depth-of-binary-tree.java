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
    class Pair{
        TreeNode node;
        int lvl;
        Pair(TreeNode in,int il){
            this.node=in;
            this.lvl=il;
        }
    }
    public int maxDepth(TreeNode A) {
        LinkedList<Pair> q=new LinkedList<>();
        int max=0;
        q.add(new Pair(A,1));
        while(q.size()>0){
            Pair current=q.removeFirst();
            TreeNode currentNode=current.node;
            int currentLvl=current.lvl;
            max=Math.max(max,currentLvl);
            if(currentNode.left!=null){
                q.add(new Pair(currentNode.left,currentLvl+1));
            }
            if(currentNode.right!=null){
                q.add(new Pair(currentNode.right,currentLvl+1));
            }
        }
        return max;
    }
}

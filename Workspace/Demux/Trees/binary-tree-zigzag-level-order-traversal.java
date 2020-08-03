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
    // it can also be done by 2 stack approach : fill stack and process stack 
    // or 2 stacks can be replaced by 2 queues as well
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        // process queue
        LinkedList<TreeNode> process=new LinkedList<>();
        // fill queue
        LinkedList<TreeNode> fill=new LinkedList<>();
        int lvl=0;
        process.add(root);
        while(process.size()>0){
            int cnt=process.size();
            List<Integer> temp=new ArrayList<>();
            while(cnt-->0){
                TreeNode fr=process.removeFirst();
                if(fr==null){
                    continue;
                }
                temp.add(fr.val); 
                if(lvl%2==0){
                    fill.addFirst(fr.left);
                    fill.addFirst(fr.right);
                }else{
                    fill.addFirst(fr.right);
                    fill.addFirst(fr.left);
                }
            }// 3 20 9 7 15 3 4 
            if(temp.size()>0){
                res.add(temp);
            }
            process=fill;
            fill=new LinkedList<>();
            lvl++;
        }
        return res;
    }
}
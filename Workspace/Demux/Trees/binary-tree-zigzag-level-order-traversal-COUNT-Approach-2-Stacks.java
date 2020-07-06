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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // use 2 stacks to keep track of the processing level 
        // and the next level nodes as well
        Stack<TreeNode> process=new Stack<>();
        Stack<TreeNode> fill=new Stack<>();
        List<List<Integer>> res=new ArrayList<>();
        // use lvl to keep track of current level
        int lvl=0;
        // init the process stack
        process.push(root);
        // using the COUNT approach
        while(process.size()>0){
            int cnt=process.size();
            ArrayList<Integer> temp=new ArrayList<>();
            while(cnt-->0){
                TreeNode fr=process.pop();
                if(fr==null){
                    continue;
                }
                temp.add(fr.val);
                // if even level then do push left child first and then right child
                // else for odd level do opposite
                if(lvl%2==0){
                    fill.push(fr.left);
                    fill.push(fr.right);
                }else{
                    fill.push(fr.right);
                    fill.push(fr.left);
                }
            }
            if(temp.size()>0){
                res.add(temp);
            }
            // make process point to fill stack
            // and fill to point to new stack i.e emptying it for new level
            process=fill;
            fill=new Stack<>();
            lvl+=1;
        }
        return res;
    }
}
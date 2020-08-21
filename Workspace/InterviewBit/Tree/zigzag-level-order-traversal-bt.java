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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        // using stack because the nodes which are being processed earlier in a level 
        // then its children will be processed very late in the next level and 
        // when the nodes are being processed very late in the current level then 
        // then its children will be processed early in the next level
        // stack lets us achieve that as it maintains a LIFO order
        Stack<TreeNode> process=new Stack<>();
        Stack<TreeNode> fill=new Stack<>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        process.push(A);
        boolean flag=true;
        // flag will be true for odd level as they have to add nodes for the next level in left to right fashion
        // flag will be false for even level as they have to add nodes for the next level in right to left fashion
        while(process.size()>0){
            int cnt=process.size();
            ArrayList<Integer> temp=new ArrayList<>();
            while(cnt-->0){
                TreeNode fr=process.pop();
                if(fr==null){
                    continue;
                }
                temp.add(fr.val);
                if(flag){
                    fill.push(fr.left);
                    fill.push(fr.right);
                }else{
                    fill.push(fr.right);
                    fill.push(fr.left);
                }
            }
            if(temp.size()>0){
                result.add(temp);
            }
            process=fill;
            fill=new Stack<>();
            flag=!flag;
        }
        return result;
    }
}

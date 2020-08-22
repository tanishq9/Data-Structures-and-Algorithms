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
    public int[] solve(TreeNode A) {
        Stack<ArrayList<Integer>> stack=new Stack<>();
        LinkedList<TreeNode> q=new LinkedList<>();
        q.add(A);
        int total=0;
        while(q.size()>0){
            int cnt=q.size();
            total+=cnt;
            ArrayList<Integer> temp=new ArrayList<>();
            while(cnt-->0){
                TreeNode fr=q.removeFirst();
                temp.add(fr.val);
                if(fr.left!=null){
                    q.add(fr.left);
                }
                if(fr.right!=null){
                    q.add(fr.right);
                }
            }
            stack.push(temp);
        }
        int[] result=new int[total];
        int index=0;
        while(stack.size()>0){
            for(int e:stack.pop()){
                result[index++]=e;
            }
        }
        return result;
    }
}

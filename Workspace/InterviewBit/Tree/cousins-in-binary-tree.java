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
    public ArrayList<Integer> solve(TreeNode A, int B) {
        LinkedList<TreeNode[]> q=new LinkedList<>();
        q.add(new TreeNode[]{A,null});
        int Bparent=-1;
        while(q.size()>0){
            int cnt=q.size();
            ArrayList<TreeNode[]> current=new ArrayList<>();
            while(cnt-->0){
                TreeNode[] fr=q.removeFirst();
                TreeNode child=fr[0];
                TreeNode parent=fr[1];
                if(child.left!=null){
                    q.add(new TreeNode[]{child.left,child});
                }
                if(child.right!=null){
                    q.add(new TreeNode[]{child.right,child});                    
                }
                if(child.val==B){
                    Bparent=parent.val;
                }
                // add all nodes on this level to current list
                current.add(fr);
            }
            if(Bparent!=-1){
                // got the child node
                ArrayList<Integer> result=new ArrayList<>();
                for(int i=0;i<current.size();i++){
                    TreeNode[] ith=current.get(i);
                    // using the constraint that cousins don't have the same parent 
                    if(ith[1].val!=Bparent){
                        result.add(ith[0].val);
                    }
                }
                return result;
            }
        }
        return null;
    }
}

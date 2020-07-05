/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    void kdown(TreeNode node,TreeNode proh,int k,ArrayList<Integer> res){
        
        if(node==null || node==proh){
            return;
        }
        
        if(k==0){
            res.add(node.val);
            return;
        }
        
        kdown(node.left,proh,k-1,res);
        kdown(node.right,proh,k-1,res);

    }
    
    ArrayList<TreeNode> getPath(TreeNode root,TreeNode target){
        if(root==null){
            return null;
        }
        if(root==target){
            ArrayList<TreeNode> base=new ArrayList<>();
            base.add(target);
            return base;
        }
        ArrayList<TreeNode> left=getPath(root.left,target);
        if(left!=null){
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right=getPath(root.right,target);
        if(right!=null){
            right.add(root);
            return right;
        }
        return null;
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ArrayList<TreeNode> nodePath=getPath(root,target);   
        ArrayList<Integer> result=new ArrayList<>();
        if(nodePath==null){
            return result;
        }
        TreeNode prohibitor=null;
        for(int i=0;i<nodePath.size();i++){
            kdown(nodePath.get(i),prohibitor,K-i,result);
            prohibitor=nodePath.get(i);
        }
        return result;
    }
}
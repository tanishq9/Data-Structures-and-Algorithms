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
    public ArrayList<Integer> solve(TreeNode A) {
        LinkedList<Pair> q=new LinkedList<>();
        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
        dfs(A,0,map);
        ArrayList<Integer> result=new ArrayList<>();
        for(int key:map.keySet()){
            result.addAll(map.get(key));
        }
        return result;
    }
    void dfs(TreeNode root,int lvl,TreeMap<Integer,ArrayList<Integer>> map){
        if(root==null){
            return;
        }
        if(!map.containsKey(lvl)){
            map.put(lvl,new ArrayList<>());
        }
        ArrayList<Integer> l=map.get(lvl);
        l.add(root.val);
        map.put(lvl,l);
        if(root.left!=null){
            dfs(root.left,lvl+1,map);
        }
        if(root.right!=null){
            dfs(root.right,lvl,map);
        }
    }
}

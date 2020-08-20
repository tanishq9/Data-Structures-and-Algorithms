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
    
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
        bfs(A,0,map);
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(int key:map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
    
    void bfs(TreeNode root,int lvl,TreeMap<Integer,ArrayList<Integer>> map){
        if(root==null){
            return;
        }
        LinkedList<Pair> q=new LinkedList<>();
        q.add(new Pair(root,lvl));
        while(q.size()>0){
            Pair fr=q.removeFirst();
            TreeNode currNode=fr.node;
            int currLvl=fr.lvl;
            // work : populate map
            if(!map.containsKey(currLvl)){
                map.put(currLvl,new ArrayList<>());
            }
            ArrayList<Integer> nodes=map.get(currLvl);
            nodes.add(currNode.val);
            map.put(currLvl,nodes);
            // push children
            if(currNode.left!=null){
                q.add(new Pair(currNode.left,currLvl-1));
            }
            if(currNode.right!=null){
                q.add(new Pair(currNode.right,currLvl+1));
            }
        }
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
            dfs(root.left,lvl-1,map);
        }
        if(root.right!=null){
            dfs(root.right,lvl+1,map);
        }
    }
}

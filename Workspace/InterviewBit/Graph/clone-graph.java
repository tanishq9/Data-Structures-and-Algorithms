/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    void dfs(UndirectedGraphNode node,boolean[] vis,HashMap<UndirectedGraphNode,UndirectedGraphNode> map){
        if(vis[node.label]){
            return;
        }
        vis[node.label]=true;
        for(int i=0;i<node.neighbors.size();i++){
            UndirectedGraphNode ngr=node.neighbors.get(i);
            // make an entry in map for old node and new node if needed
            map.putIfAbsent(node,new UndirectedGraphNode(node.label));
            // populate children's list of new node using old node's children
            map.putIfAbsent(ngr,new UndirectedGraphNode(ngr.label));
            map.get(node).neighbors.add(map.get(ngr));

            // call dfs for its children (old node) 
            dfs(ngr,vis,map);
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // handling empty graph case
        if(node==null){
            return null;
        }
        // handling no neighbors case
        if(node.neighbors.size()==0){
            return new UndirectedGraphNode(node.label);
        }
        // similar approach to linked list cloning
        // maintain a map for old node and new node
        // use dfs to populate the map and assign children on the go
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();
        boolean[] vis=new boolean[100000001];
        dfs(node,vis,map);
        return map.get(node);
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    void dfs(Node node,boolean[] vis,HashMap<Node,Node> map){
        if(vis[node.val]){
            return;
        }
        vis[node.val]=true;
        for(int i=0;i<node.neighbors.size();i++){
            Node ngr=node.neighbors.get(i);
            // make an entry in map for old node and new node if needed
            map.putIfAbsent(node,new Node(node.val));
            // populate children's list of new node using old node's children
            map.putIfAbsent(ngr,new Node(ngr.val));
            map.get(node).neighbors.add(map.get(ngr));

            // call dfs for its children (old node) 
            dfs(ngr,vis,map);
        }
    }
    
    public Node cloneGraph(Node node) {
        // handling empty graph case
        if(node==null){
            return null;
        }
        // handling no neighbors case
        if(node.neighbors.size()==0){
            return new Node(node.val);
        }
        // similar approach to linked list cloning
        // maintain a map for old node and new node
        // use dfs to populate the map and assign children on the go
        HashMap<Node,Node> map=new HashMap<>();
        boolean[] vis=new boolean[101];
        dfs(node,vis,map);
        return map.get(node);
    }
}
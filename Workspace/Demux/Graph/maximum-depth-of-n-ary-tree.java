/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Pair{
    Node node;
    int h;
    Pair(Node in,int ih){
        this.node=in;
        this.h=ih;
    }
}

class Solution {
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        LinkedList<Pair> q=new LinkedList<>();
        q.add(new Pair(root,1));
        int maxh=0;
        while(q.size()>0){
            Pair fr=q.removeFirst();
            Node cnode=fr.node;
            int ch=fr.h;
            maxh=Math.max(maxh,ch);
            for(int i=0;i<cnode.children.size();i++){
                Node child=cnode.children.get(i);
                q.add(new Pair(child,ch+1));
            }
        }
        return maxh;
    }
}
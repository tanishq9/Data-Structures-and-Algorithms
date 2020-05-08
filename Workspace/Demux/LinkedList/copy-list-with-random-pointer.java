https://leetcode.com/problems/copy-list-with-random-pointe

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        // make a map of old node and corresponding new node 
        HashMap<Node,Node> map=new HashMap<>();
        // init temp and index
        Node temp=head;
        Node newNode=null;
        // build the map
        while(temp!=null){
            newNode=new Node(temp.val);
            map.put(temp,newNode);
            temp=temp.next;
        }
        temp=head;
        // assign next and random for each node of the new list
        while(temp!=null){
            newNode=map.get(temp);
            newNode.next=map.get(temp.next);
            newNode.random=map.get(temp.random);
            temp=temp.next;
        }
        return map.get(head);
    }
    
}
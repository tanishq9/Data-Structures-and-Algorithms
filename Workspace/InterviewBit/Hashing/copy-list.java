/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode temp=head;
        // map of old node and corresponding new node
        HashMap<RandomListNode,RandomListNode> map=new HashMap<>();
        while(temp!=null){
            map.put(temp,new RandomListNode(temp.label));
            temp=temp.next;
        }
        temp=head;
        RandomListNode newHead=null,newTail=null;
        while(temp!=null){
            RandomListNode node=map.get(temp);
            node.next=map.get(temp.next);
            node.random=map.get(temp.random);
            if(newHead==null){
                newHead=node;
                newTail=node;
            }else{
                newTail.next=node;
                newTail=node;
            }
            temp=temp.next;
        }
        return newHead;
    }
}

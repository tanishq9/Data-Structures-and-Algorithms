/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        // calculate size of the list
        int sz=0;
        ListNode temp=A;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        // B is now the node to be removed from the starting
        B=sz-B+1;
        if(B<=1){
            return A.next;
        }
        // aim is to get to the node just before the node to be deleted
        int aim=B-1;
        int curr=1;
        temp=A;
        
        while(temp!=null){
            // if we have reached the prev node of the node which has to be deleted
            if(curr==aim){
                // if node to be removed is not null 
                if(temp.next!=null){
                    // forming a new link of prev and next's next node
                    ListNode deletedNode=temp.next;
                    temp.next=deletedNode.next;
                    // unlinking that node from the chain
                    deletedNode.next=null;
                }
            }
            curr++;
            temp=temp.next;
        }
        return A;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode dummyHead=null,dummyTail=null;
        ListNode curr=A;
        while(curr!=null){
            // skip past the duplicate nodes
            if(curr!=null && curr.next!=null && curr.val==curr.next.val){
                while(curr!=null && curr.next!=null && curr.val==curr.next.val){
                    curr=curr.next;
                }
            }else{
                // use dummy nodes to extend the required list
                if(dummyHead==null){
                    dummyHead=curr;
                    dummyTail=curr;
                }else{
                    dummyTail.next=curr;
                    dummyTail=curr;                
                }
            }
            // move to the next node
            curr=curr.next;
        }
        if(dummyTail!=null){
            dummyTail.next=null;
        }
        return dummyHead!=null?dummyHead:null;
    }
}

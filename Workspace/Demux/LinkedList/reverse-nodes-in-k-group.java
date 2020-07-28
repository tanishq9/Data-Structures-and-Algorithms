/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    void reverse(ListNode start,ListNode end){
        ListNode curr=start,prev=null;
        while(prev!=end){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
    }
    
    public ListNode reverseKGroup(ListNode A, int B) {
         ListNode temp=A,newHead=null,lastRev=null;
        // lastRev will help to keep track of the last node of the k size reversed list
        // it will be used to point last node of reversed list to the start of the next reversed list
        
        // The idea is to reverse k nodes and keep the reversed last node of each of these k chains, 
        // and make the reversed last node point to the head node of next reversed chain.
        while(temp!=null){
            ListNode start=temp,end=temp,endNext=null;
            int elements=B-1;
            while(end!=null && elements-->0){
                end=end.next;
            }
            if(end==null){
                if(lastRev!=null){
                    lastRev.next=start;
                }
                break;
            }
            endNext=end.next;
            reverse(start,end);
            if(lastRev==null){
                lastRev=start;
            }else{
                lastRev.next=end;
                lastRev=start;
            }
            if(newHead==null){
                newHead=end;
            }
            // move to the next group of B size
            temp=endNext;
        }
        return newHead;
    }
}
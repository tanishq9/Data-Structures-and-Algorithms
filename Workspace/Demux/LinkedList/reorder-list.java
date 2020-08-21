/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode mid=null,slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        mid=slow.next;
        slow.next=null;
        // reverse second part now
        mid=reverse(mid);
        // do alternate merge now
        ListNode p1=head,p2=mid;
        boolean flag=true;
        while(p1!=null && p2!=null){
            if(flag){
                ListNode temp=p1.next;
                p1.next=p2;
                p1=temp;
            }else{
                ListNode temp=p2.next;
                p2.next=p1;
                p2=temp;
            }
            flag=!flag;
        }
    }
    
    ListNode reverse(ListNode node){
        ListNode prev=null,curr=node;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    
    
}
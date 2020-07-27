/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    ListNode reverse(ListNode node){
        ListNode curr=node,prev=null;
        int size=0;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            size++;
        }
        return prev;
    }
    
    public ListNode reorderList(ListNode A) {
        ListNode slow=A,fast=A;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode part1=A;
        ListNode part2=slow.next;
        slow.next=null;
        part2=reverse(part2);
        // now do alternate merge of part1 and part2
        boolean flag=true;
        while(part1!=null && part2!=null){
            if(flag){
                ListNode temp=part1.next;
                part1.next=part2;
                part1=temp;
            }else{
                ListNode temp=part2.next;
                part2.next=part1;
                part2=temp;                
            }
            flag=!flag;
        }
        return A;
    }
}

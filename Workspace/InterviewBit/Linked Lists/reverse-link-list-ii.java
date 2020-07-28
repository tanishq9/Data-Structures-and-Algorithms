/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    ListNode reverse(ListNode head,ListNode tail){
        ListNode curr=head,prev=null;
        while(prev!=tail){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode temp=A,revPrev=null,revNext=null,revHead=null,revTail=null;
        int position=1;
        while(temp!=null){
            if(position==B-1){
                revPrev=temp;
            }else if(position==B){
                revHead=temp;
                // since m and n can be the same, so we initialize revTail also here
                revTail=temp;
            }else if(position==C){
                revTail=temp;
            }else if(position==C+1){
                revNext=temp;
                break;
            }
            position++;
            temp=temp.next;
        }
        if(revPrev!=null){
            revPrev.next=reverse(revHead,revTail);
            revHead.next=revNext;
            return A;
        }else{
            ListNode newHead=reverse(revHead,revTail);
            revHead.next=revNext;
            return newHead;
        }
    }
}

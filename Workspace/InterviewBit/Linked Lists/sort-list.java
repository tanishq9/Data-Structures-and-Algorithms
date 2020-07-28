/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    
    public ListNode sortList(ListNode A) {
        return merge(A);
    }
    
    ListNode merge(ListNode A){
        if(A==null || A.next==null){
            return A;
        }
        ListNode mid=getMid(A);
        ListNode midNext=mid.next;
        mid.next=null;
        ListNode left=merge(A);
        ListNode right=merge(midNext);
        return merge2Lists(left,right);
    }
    
    ListNode getMid(ListNode head){
        ListNode slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    // Merging 2 Sorted Lists in place
    ListNode merge2Lists(ListNode A,ListNode B){
        ListNode pStart=null,pEnd=null,p1=A,p2=B;
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                if(pStart==null){
                    pStart=p1;
                    pEnd=p1;
                }else{
                    pEnd.next=p1;
                    pEnd=pEnd.next;
                }
                p1=p1.next;
            }else{
                if(pStart==null){
                    pStart=p2;
                    pEnd=p2;
                }else{
                    pEnd.next=p2;
                    pEnd=pEnd.next;
                }
                p2=p2.next;
            }
        }
        while(p1!=null){
            pEnd.next=p1;
            pEnd=pEnd.next;
            p1=p1.next;
        }
        while(p2!=null){
            pEnd.next=p2;
            pEnd=pEnd.next;
            p2=p2.next;
        }
        return pStart;
    }
}

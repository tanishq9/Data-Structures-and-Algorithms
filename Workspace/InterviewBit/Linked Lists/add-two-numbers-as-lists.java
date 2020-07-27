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
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode p1=null,p2=null,pStart=null,pEnd=null;
        // pStart -> head pointer to the sorted list formed
        // pEnd -> tail of the sorted list formed
        // p1 -> pointer to traverse list A 
        // p2 -> pointer to traverse list B
        p1=A; // reverse(A);
        p2=B; // reverse(B);
        int carry=0;
        while(p1!=null && p2!=null){
            int val1=p1.val;
            int val2=p2.val;
            // val will be added
            int sum=(val1+val2+carry);
            if(pStart==null){
                pStart=new ListNode(sum%10);
                pEnd=pStart;
            }else{
                ListNode temp=new ListNode(sum%10);
                pEnd.next=temp;
                pEnd=temp;
            }
            // update the carry
            carry=sum/10;
            
            // move the pointer for lists A and B
            p1=p1.next;
            p2=p2.next;
        }
        while(p1!=null){
            int sum=p1.val+carry;
            ListNode temp=new ListNode(sum%10);
            pEnd.next=temp;
            pEnd=temp;
            carry=sum/10;
            p1=p1.next;
        }
        while(p2!=null){
            int sum=p2.val+carry;
            ListNode temp=new ListNode(sum%10);
            pEnd.next=temp;
            pEnd=temp;
            carry=sum/10;
            p2=p2.next;
        }
        if(carry!=0){
            ListNode temp=new ListNode(carry);
            pEnd.next=temp;
            pEnd=temp;
        }
        return pStart;
    }
}

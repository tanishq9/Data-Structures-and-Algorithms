/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        // pStart -> head pointer to the sorted list formed
        // pEnd -> tail of the sorted list formed
        // p1 -> pointer to traverse list A 
        // p2 -> pointer to traverse list B
        // It could have also be done without using pointer p1 and p2 by directly using A and B
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

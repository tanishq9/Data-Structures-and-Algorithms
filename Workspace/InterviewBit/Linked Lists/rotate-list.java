/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode A, int B) {
        int sz=0;
        ListNode temp=A,lastNode=null;
        while(temp!=null){
            if(temp.next==null){
                lastNode=temp;
            }
            sz++;
            temp=temp.next;
        }
        B=B%sz;
        if(B==0){
            return A;
        }
        // get prev node of rotated head 
        int kth=sz-B-1;
        temp=A;
        while(kth-->0){
            temp=temp.next;
        }
        ListNode rotatedHead=temp.next;
        temp.next=null;
        lastNode.next=A;
        return rotatedHead;
    }
}

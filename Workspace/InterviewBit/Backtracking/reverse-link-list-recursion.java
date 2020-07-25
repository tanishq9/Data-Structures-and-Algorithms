/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    ListNode head;
    void reverse(ListNode A){
        if(A.next==null){
            head=A;
            return;
        }
        reverse(A.next);
        A.next.next=A;
    }
    
    public ListNode reverseList(ListNode A) {
        ListNode temp=A;
        reverse(temp);
        A.next=null;
        return head;
    }
}

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
        ListNode prev=A,temp=A.next;
        while(temp!=null){
            while(temp!=null && prev.val==temp.val){
                temp=temp.next;
            }
            prev.next=temp;
            prev=temp;
            if(temp!=null){
                temp=temp.next;    
            }
        }
        return A;
    }
}

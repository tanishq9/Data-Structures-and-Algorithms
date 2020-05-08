/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                if(head==null){
                    head = new ListNode(l1.val);
                    tail = head;
                }else{
                    tail.next = new ListNode(l1.val);
                    tail = tail.next;
                }
                l1=l1.next;
            }else{
                if(head==null){
                    head = new ListNode(l2.val);
                    tail = head;
                }else{
                    tail.next = new ListNode(l2.val);
                    tail = tail.next;
                }
                l2=l2.next;
            }
        }
        while(l1!=null){
            if(head==null){
                head = new ListNode(l1.val);
                tail = head;
            }else{
                tail.next = new ListNode(l1.val);
                tail = tail.next;
            }
            l1=l1.next;
        }
        while(l2!=null){
            if(head==null){
                head = new ListNode(l2.val);
                tail = head;
            }else{
                tail.next = new ListNode(l2.val);
                tail = tail.next;
            }
            l2=l2.next;
        }
        return head;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode oddHead = null, oddTail = null, evenHead = null, evenTail = null;
        ListNode temp = head;
        int index = 0;
       
        while(temp != null){
            if(index%2 == 0){
                if(evenHead == null){
                    evenHead = temp;
                    evenTail = temp;
                }else{
                    evenTail.next = temp;
                    evenTail = temp;
                }
            }else{
                if(oddHead == null){
                    oddHead = temp;
                    oddTail = temp;
                }else{
                    oddTail.next = temp;
                    oddTail = temp;
                }
            }
            index++;
            temp = temp.next;
        }
        evenTail.next = oddHead;
        oddTail.next = null;
        return evenHead;   
    }
}
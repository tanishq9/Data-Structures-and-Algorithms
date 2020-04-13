/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int target=size-n+1;
        if(target==1){
            return head.next;
        }
        int index=1;
        temp=head;
        ListNode prev=head;
        while(index!=target){
            index++;
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
        temp.next=null;
        return head;
    }
}

    /*1->2->3->4->5->6
    size = 6
    size - k from beginning 
    6 - 5 +1 = 1+1 = 2
    Kth from end = (N-k+1)th from beginning*/
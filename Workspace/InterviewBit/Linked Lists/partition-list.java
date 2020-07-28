/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode A, int B) {
        ListNode smallerHead=null,smallerTail=null;
        ListNode largerEqualHead=null,largerEqualTail=null;
        ListNode temp=A;
        while(temp!=null){
            int val=temp.val;
            if(val<B){
                if(smallerHead==null){
                    smallerHead=temp;
                    smallerTail=temp;
                }else{
                    smallerTail.next=temp;
                    smallerTail=temp;
                }
            }else{
                if(largerEqualHead==null){
                    largerEqualHead=temp;
                    largerEqualTail=temp;
                }else{
                    largerEqualTail.next=temp;
                    largerEqualTail=temp;
                }
            }
            temp=temp.next;
        }
        if(smallerHead!=null){
            smallerTail.next=largerEqualHead;
            if(largerEqualHead!=null){
                largerEqualTail.next=null;
            }
            return smallerHead;
        }else{
            if(largerEqualHead!=null){
                largerEqualTail.next=null;
            }
            return largerEqualHead;
        }
    }
}

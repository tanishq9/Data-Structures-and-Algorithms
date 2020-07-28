/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A, int B) {
        ListNode slow=A,fast=A,result=null;
        int mIndex=1;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            mIndex++;
        }
        int kth=mIndex-B;
        if(kth<1){
            return -1;
        }
        slow=A;
        while(kth-->0){
            result=slow;
            slow=slow.next;
        }
        return result.val;
    }
}

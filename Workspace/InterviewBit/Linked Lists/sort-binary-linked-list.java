/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
        ListNode zeroHead=null,zeroTail=null,oneHead=null,oneTail=null;
        ListNode temp=A;
        while(temp!=null){
            if(temp.val==0){
                if(zeroHead==null){
                    zeroHead=temp;
                    zeroTail=temp;
                }else{
                    zeroTail.next=temp;
                    zeroTail=temp;
                }
            }else{
                if(oneHead==null){
                    oneHead=temp;
                    oneTail=temp;
                }else{
                    oneTail.next=temp;
                    oneTail=temp;
                }
            }
            temp=temp.next;
        }
        if(zeroHead==null){
            return oneHead;
        }else{
            zeroTail.next=oneHead;
            if(oneHead!=null){
                oneTail.next=null;
            }
            return zeroHead;
        }
    }
}

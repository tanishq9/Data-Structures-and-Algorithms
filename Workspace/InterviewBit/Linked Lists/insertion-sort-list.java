/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode A) {
        ListNode temp=A.next,newHead=null;
        while(temp!=null){
            ListNode insertionPointNextNode=temp.next;
            ListNode insertionPoint=newHead==null?A:newHead,insertionPointPrev=null;
            // find the insertion point
            while(insertionPoint!=temp){
                if(insertionPoint.val>temp.val){
                    break;
                }
                insertionPointPrev=insertionPoint;
                insertionPoint=insertionPoint.next;
            }
            if(insertionPoint==temp){
                temp=insertionPointNextNode;
                continue;
            }
            if(insertionPointPrev==null){
                if(newHead==null){
                    temp.next=A;
                    newHead=temp;
                }else{
                    temp.next=newHead;
                    newHead=temp;
                }
            }else{
                insertionPointPrev.next=temp;
                temp.next=insertionPoint;
            }
            while(insertionPoint!=temp){
                insertionPointPrev=insertionPoint;
                insertionPoint=insertionPoint.next;
            }
            insertionPointPrev.next=insertionPointNextNode;
            temp=insertionPointNextNode;
        }
        return newHead!=null?newHead:A;
    }
}

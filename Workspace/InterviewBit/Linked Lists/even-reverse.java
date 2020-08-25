/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    ListNode reverse(ListNode node){
        ListNode prev=null,curr=node;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode solve(ListNode A) {
        ListNode oddHead=null,oddTail=null,evenHead=null,evenTail=null;
        ListNode temp=A;
        int index=1;
        while(temp!=null){
            if(index%2==0){
                if(evenHead==null){
                    evenHead=temp;
                    evenTail=temp;
                }else{
                    evenTail.next=temp;
                    evenTail=temp;
                }
            }else{
                if(oddHead==null){
                    oddHead=temp;
                    oddTail=temp;
                }else{
                    oddTail.next=temp;
                    oddTail=temp;
                }
            }
            temp=temp.next;
            index+=1;
        }
        if(index<=3){
            return A;
        }
        oddTail.next=null;
        evenTail.next=null;
        evenHead=reverse(evenHead);
        boolean flag=true;
        ListNode p1=oddHead,p2=evenHead;
        while(p1!=null && p2!=null){
            if(flag){
                temp=p1.next;
                p1.next=p2;
                p1=temp;
            }else{
                temp=p2.next;
                p2.next=p1;
                p2=temp;
            }
            flag=!flag;
        }
        return oddHead;
    }
}

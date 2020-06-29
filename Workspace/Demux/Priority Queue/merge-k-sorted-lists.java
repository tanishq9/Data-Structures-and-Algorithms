/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<>(){
            public int compare(ListNode l1,ListNode l2){
                return l1.val-l2.val;
            }
        });
        for(int i=0;i<lists.length;i++){
            // add k heads to the priority queue initially 
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        ListNode head=null,temp=null;
        while(pq.size()>0){
            ListNode peek=pq.remove();
            if(head==null){
                head=peek;
                temp=peek;
            }else{
                temp.next=peek;
                temp=peek;
            }
            if(peek.next!=null){
                pq.add(peek.next);
            }
        }
        return head;
    }
}
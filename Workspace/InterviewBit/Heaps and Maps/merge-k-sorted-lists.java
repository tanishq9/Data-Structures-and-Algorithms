/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1,ListNode l2){
                return l1.val-l2.val;
            }
        });
        for(int i=0;i<a.size();i++){
            pq.add(a.get(i));
        }
        ListNode head=null,tail=null;
        while(pq.size()>0){
            ListNode fr=pq.remove();
            if(head==null){
                head=fr;
                tail=fr;
            }else{
                tail.next=fr;
                tail=fr;
            }
            if(fr.next!=null){
                pq.add(fr.next);
            }
        }
        return head;
    }
}

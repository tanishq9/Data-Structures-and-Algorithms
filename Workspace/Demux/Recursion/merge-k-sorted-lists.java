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
    
    ListNode merge(int start,int end,ListNode[] lists){
        if(start>end){
            return null;
        }
        if(start==end){
            return lists[start];
        }
        int mid=start+(end-start)/2;
        ListNode left=merge(start,mid,lists);
        ListNode right=merge(mid+1,end,lists);
        return merger(left,right);
    }
    
    ListNode merger(ListNode left,ListNode right){
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        if(left.val<right.val){
            left.next=merger(left.next,right);
            return left;
        }else{
            right.next=merger(left,right.next);
            return right;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        // recursively
        return merge(0,lists.length-1,lists);
    }
}
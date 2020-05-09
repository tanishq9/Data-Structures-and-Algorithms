package LinkedList;

public class FloydLoop {
	/**
	 * Definition for singly-linked list. class ListNode { public int val; public
	 * ListNode next; ListNode(int x) { val = x; next = null; } }
	 */
	/*
	 * public class Solution { public ListNode detectCycle(ListNode a) { ListNode
	 * slow=a,fast=a; boolean isloop=false; while(fast.next!=null &&
	 * fast.next.next!=null){ slow=slow.next; fast=fast.next.next; if(slow==fast){
	 * slow=a; isloop=true; break; } } if(isloop==false){ return null; }
	 * while(slow!=fast){ slow=slow.next; fast=fast.next; } return slow; } }
	 */

}

package LinkedList;

public class MergePoint {
	/**
	 * Definition for singly-linked list. class ListNode { public int val; public
	 * ListNode next; ListNode(int x) { val = x; next = null; } }
	 */
	/*
	 * public class Solution { public ListNode getIntersectionNode(ListNode a,
	 * ListNode b) { int a_length = getLength(a); int b_length = getLength(b); int d
	 * = b_length - a_length;
	 * 
	 * ListNode A = a; ListNode B = b;
	 * 
	 * if(a_length > b_length) { ListNode temp = A; A = B; B = temp; d = a_length -
	 * b_length; }
	 * 
	 * for(int i=0; i<d; i++) { B = B.next; }
	 * 
	 * while(A != null && B != null) { if(A == B) { return A; } A = A.next; B =
	 * B.next; }
	 * 
	 * return null; }
	 * 
	 * public int getLength(ListNode a) { int count = 0; ListNode b = a;
	 * 
	 * while(b != null) { count++; b = b.next; }
	 * 
	 * return count; } }
	 * 
	 */
}

package LinkedList;

public class Merge2Lists {

	// Definition for singly-linked list.
	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class Solution {
		public ListNode mergeTwoLists(ListNode A, ListNode B) {
			ListNode sptr, head;
			if (A.val < B.val) {
				sptr = new ListNode(A.val);
				head = sptr;
				A = A.next;
			} else {
				sptr = new ListNode(B.val);
				head = sptr;
				B = B.next;
			}
			while (A != null && B != null) {
				if (A.val > B.val) {
					head.next = new ListNode(B.val);
					head = head.next;
					B = B.next;
				} else {
					head.next = new ListNode(A.val);
					head = head.next;
					A = A.next;
				}
			}
			while (A != null) {
				head.next = new ListNode(A.val);
				head = head.next;
				A = A.next;
			}
			while (B != null) {
				head.next = new ListNode(B.val);
				head = head.next;
				B = B.next;
			}
			return sptr;
		}
	}

}

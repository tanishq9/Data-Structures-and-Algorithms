package LinkedList;

public class ReverseWithinRangeMandN {
	/**
	 * Definition for singly-linked list.
	 */
	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class Solution {
		ListNode head = null;

		public ListNode reverse(ListNode head) {
			ListNode prev = head;
			ListNode curr = head.next;
			while (curr != null) {
				ListNode tempcurr = curr;
				ListNode tempprev = prev;
				prev = curr;
				curr = curr.next;
				tempcurr.next = tempprev;
			}
			return prev;
		}

		public ListNode reverseBetween(ListNode A, int B, int C) {
			if (B == C) {
				return A;
			}
			ListNode revs = null, revs_prev = null, revs_end = null, revs_end_next = null;
			int i = 1;
			ListNode temp = A;
			while (temp != null && i <= C) {
				if (i < B) {
					revs_prev = temp;
				} else if (i == B) {
					revs = temp;
				} else if (i == C) {
					revs_end = temp;
					revs_end_next = revs_end.next;
				}
				i++;
				temp = temp.next;
			}
			revs_end.next = null;
			revs_end = reverse(revs);
			if (revs_prev != null) {
				revs_prev.next = revs_end;
			} else {
				A = revs_end;
			}
			revs.next = revs_end_next;
			return A;
		}
	}

}

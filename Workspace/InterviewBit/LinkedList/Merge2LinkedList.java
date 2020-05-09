package LinkedList;

public class Merge2LinkedList {
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

		private ListNode getMid(ListNode node) {
			ListNode slow = node;
			ListNode fast = node;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
		}

		public ListNode sortList(ListNode A) { // Base Case
			if (A == null || A.next == null) {
				return A;
			}
			ListNode mid = getMid(A);
			ListNode nextToMid = mid.next;
			mid.next = null; 
			// Left part of the linked list
			ListNode left = sortList(A);
			// right part of the linked list 
			ListNode right = sortList(nextToMid); return
			merge2ListsInPlace(left, right);
		}

		private ListNode merge2ListsInPlace(ListNode left, ListNode right) {
			ListNode new_head = null, sortingPtr = null;
			if (left.val < right.val) {
				sortingPtr = left;
				new_head = left;
				left = sortingPtr.next;
			} else {
				sortingPtr = right;
				new_head = right;
				right = sortingPtr.next;
			}

			while (left != null && right != null) {
				if (left.val < right.val) {
					sortingPtr.next = left;
					sortingPtr = left;
					left = sortingPtr.next;
				} else {
					sortingPtr.next = right;
					sortingPtr = right;
					right = sortingPtr.next;
				}
			}

			if (left == null) {
				sortingPtr.next = right;
			} else if (right == null) {
				sortingPtr.next = left;
			}

			return new_head;
		}
	}

}
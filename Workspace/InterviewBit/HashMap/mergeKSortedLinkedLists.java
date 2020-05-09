package HashMap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class mergeKSortedLinkedLists {
	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class Solution {
		class kheap implements Comparable<kheap> {
			int data;
			ListNode dataNode;

			kheap(int id, ListNode idn) {
				this.data = id;
				this.dataNode = idn;
			}

			public int compareTo(kheap other) {
				if (this.data > other.data) {
					return 1;
				} else if (this.data < other.data) {
					return -1;
				} else {
					return 0;
				}
			}
		}

		public ListNode mergeKLists(ArrayList<ListNode> a) {
			PriorityQueue<kheap> pq = new PriorityQueue<>();
			for (int i = 0; i < a.size(); i++) {
				kheap k = new kheap(a.get(i).val, a.get(i));
				pq.add(k);
			}
			ListNode l = null, lcpy = null;
			while (pq.size() > 0) {
				kheap top = pq.remove();
				ListNode dNode = top.dataNode;
				if (l == null) {
					l = dNode;
					lcpy = l;
				} else {
					l.next = dNode;
					l = l.next;
				}
				dNode = dNode.next; // Increment the data index so as to include the next element
				if (dNode != null) {
					pq.add(new kheap(dNode.val, dNode));
				}
			}
			return lcpy;
		}
	}

}

package LinkedList;

public class maxPalindromeLL {
	static int getCommon(Node a, Node b) {
		int count = 0;
		while (a != null && b != null && a.data == b.data) {
			a = a.next;
			b = b.next;
			count++;
		}
		return count;
	}

	public static int maxPalindrome(Node head) {
		Node prev = null;
		Node curr = head;
		int max = Integer.MIN_VALUE;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;

			// Check for odd length
			max = Math.max(max, 2 * getCommon(prev, next) + 1);
			// Check for even length
			max = Math.max(max, 2 * getCommon(curr, next));

			prev = curr;
			curr = next;
		}
		return max;
	}
}

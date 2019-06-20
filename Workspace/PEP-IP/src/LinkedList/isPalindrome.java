package LinkedList;

public class isPalindrome {
	static Node left;

	// -----------------------------------------------------
	// This is a functional problem. You have to complete this function.
	// This function takes as input the head of the linked list.
	// It should return true if list is palindrome, else return false.

	public static boolean isPalindrome(Node head) {
		left = head;
		return isPalin(head);
	}

	static boolean isPalin(Node head) {
		if (head == null) {
			return true;
		}
		boolean result = isPalin(head.next);
		if (result == false || left.data != head.data) {
			return false;
		}
		left = left.next;
		return true;
	}

}

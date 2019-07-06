package LinkedList;

public class identicalList {
	public static boolean isIdentical(Node h1, Node h2) {
		// write your code here and return true if they are identical, otherwise
		while (h1 != null && h2 != null) {
			if (h1.data != h2.data) {
				return false;
			}
			h1 = h1.next;
			h2 = h2.next;
		}
		return h1 == null && h2 == null;
	}
}

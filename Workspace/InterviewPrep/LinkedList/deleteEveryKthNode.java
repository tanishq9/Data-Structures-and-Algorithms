package LinkedList;

public class deleteEveryKthNode {
	public static Node delete(Node n, int k) {
		if (k == 0) {
			return n;
		}
		Node temp = n;
		int index = 1;
		while (temp != null) {
			if ((index + 1) % k == 0) {
				if (temp.next != null) {
					temp.next = temp.next.next;
					temp = temp.next;
					index += 2;
					continue;
				} else {
					break;
				}
			}
			temp = temp.next;
			index++;
		}
		return n;
	}

}

package LinkedList;

public class splitLLinKParts {
	public static Node[] splitListToParts(Node head, int k) {
		int n = 0;
		Node temp = head;
		while (temp != null) {
			n++;
			temp = temp.next;
		}
		int width = n / k;
		int rem = n % k; // To get the extra nodes
		Node[] arr = new Node[k];
		temp = head;
		for (int i = 0; i < k; i++) {
			Node chead = temp;
			for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; j++) {
				if (temp != null) {
					temp = temp.next;
				}
			}
			if (temp != null) {
				Node prev = temp;
				temp = temp.next;
				prev.next = null;
			}
			arr[i] = chead;
		}
		return arr;
	}
}
